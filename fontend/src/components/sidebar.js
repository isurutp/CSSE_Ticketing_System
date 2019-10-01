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
      JourneyHis: ["","","",""],
      TotalFare: 3542.00,
      TotalJourneys: 56
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
  details = details.replace('[','')
  details = details.replace(']','')
  details = details.replace(/\"/g,'')
  var myArray = details.split(',');

  this.setState({JourneyHis: myArray});
  }

}

  render() {
    const Trips= [
        {Date: this.state.JourneyHis[0], From: this.state.JourneyHis[1], To: this.state.JourneyHis[2], price: this.state.JourneyHis[3]},
      {Date: '2019-07-18', From: 'Kaduwela', To: 'Nugegoda', price: 50.00}
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
                    <th>LKR {this.state.TotalFare}.00</th>
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