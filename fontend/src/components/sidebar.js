import React, {Component} from 'react';
import Cookies from 'universal-cookie';
import Graph from "./SidebarGraph";



export default class sidebar extends Component {
  constructor() {
    super();
    const userDetails = new Cookies();
    this.state = {
      name: userDetails.get('username'),
      Location: 'Malabe',
      JourneyHis0: ["","","",""],
      JourneyHis1: ["","","",""],
      JourneyHis2: ["","","",""],
      JourneyHis3: ["","","",""],
      TotalFare: 0.00,
      TotalJourneys: 0
    };

    this.getDetails = this.getDetails.bind(this);

    this.getDetails();
    
}

async getDetails()
{
  //Getting User's address from backend
  var address = await fetch(`/getAddress?username=${this.state.name}`)
                  .then(function(response){ return response.text(); })
  this.setState({Location: address});

  //Getting user's journey history from backend
  var details = await fetch(`/searchJourneysTaken?username=${this.state.name}`)
  .then(function(response){ return response.text(); })

  if(!details.includes("error"))
  {
    var myArray = details.split('],[');
    var result = ["","","",""]
    for(var i=0;i<4;i++)
    {
      myArray[i] = myArray[i].replace(/\[/g,'')
      myArray[i] = myArray[i].replace(/\]/g,'')
      myArray[i] = myArray[i].replace(/\"/g,'')
      result[i] = myArray[i].split(',')
    }

  this.setState({JourneyHis0: result[0]});
  this.setState({JourneyHis1: result[1]});
  this.setState({JourneyHis2: result[2]});
  this.setState({JourneyHis3: result[3]});
  }

  //Getting user's Total Fares from backend
  var TotFare = await fetch(`/searchFaresPaid?username=${this.state.name}`)
  .then(function(response){ return response.text(); })

  if(!!TotFare)
  {
    this.setState({TotalFare: TotFare});
  }

  //Getting user's Total Number of Journeys from backend
  var total = await fetch(`/TotalJourneys?username=${this.state.name}`)
  .then(function(response){ return response.text(); })

  if(!!total)
  {
    this.setState({TotalJourneys: total});
  }

}

  render() {
    const Trips= [
        {Date: this.state.JourneyHis0[0], From: this.state.JourneyHis0[1], To: this.state.JourneyHis0[2], price: this.state.JourneyHis0[3]},
        {Date: this.state.JourneyHis1[0], From: this.state.JourneyHis1[1], To: this.state.JourneyHis1[2], price: this.state.JourneyHis1[3]},
        {Date: this.state.JourneyHis2[0], From: this.state.JourneyHis2[1], To: this.state.JourneyHis2[2], price: this.state.JourneyHis2[3]},
        {Date: this.state.JourneyHis3[0], From: this.state.JourneyHis3[1], To: this.state.JourneyHis3[2], price: this.state.JourneyHis3[3]},

      ]

    const TripItems = Trips.map((Trips) =>
    <tr>
      <td>{Trips.Date}</td>
      <td>{Trips.From}</td>
      <td>{Trips.To}</td>
      <td>{Trips.price}</td>
    </tr>
    );


    return (
      <div style={{textAlign: 'center'}}>
          <meta name="viewport" content="width=device-width, initial-scale=1" />
          <link rel="stylesheet" href="assets/external.css" />
          <link rel="stylesheet" href="assets/roundImage.css" />

          <div className="w3-sidebar w3-bar-block w3-card" style={{width: '30%', right: 0, overflow:'auto', height:500}}>
            <br/>
              <img src="img_avatar.png" alt="Avatar" style={{width: '100px'}} />
              <br/>
              <h3 className="w3-bar-item" style={{textAlign: 'center'}}>{this.state.name}</h3>
              <h5 className="w3-bar-item" style={{textAlign: 'center'}}>{this.state.Location}</h5>
              <br/><br/>
              <div>
                <table style={{width: '100%'}}>
                  <tr>
                    <th>{this.state.TotalJourneys}</th>
                    <th>LKR {this.state.TotalFare}</th>
                  </tr>
                  <tr>
                  <td>Journeys</td>
                  <td>Total Fares</td>
                </tr>
                </table>
              </div>
              <Graph/>
              <br/><br/>
              <h5 className="w3-bar-item" style={{textAlign: 'center'}}>Recent Activity</h5>
              <br/>
              <table style={{width: '100%'}}>
                <tr>
                  <th>Date</th>
                  <th>From</th>
                  <th>To</th>
                  <th>Price</th>
                </tr>
                <br/>
                  {TripItems}
              </table>
              <br/><br/><br/><br/>
          </div>
      </div>
    );
  }
}