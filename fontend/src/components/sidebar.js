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
      TotalFare: 3542.00,
      TotalJourneys: 56
    };

    this.getLocation = this.getLocation.bind(this);

    this.getLocation();
    
}

async getLocation()
{
  //Getting data from backend
  var address = await fetch(`/getAddress?username=${this.state.name}`)
                  .then(function(response){ return response.text(); })
  this.setState({Location: address});

}

  render() {

    const Trips= [
      {id: '01', item: 'July 20th', color: 'Malabe', size: 'Kandy', price: 125.00},
      {id: '02', item: 'July 18th', color: 'Kaduwela', size: 'Nugegoda', price: 50.00}
      ]

    const TripItems = Trips.map((Trips) =>
    <tr>
      <td>{Trips.item}</td>
      <td>{Trips.color}</td>
      <td>{Trips.size}</td>
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