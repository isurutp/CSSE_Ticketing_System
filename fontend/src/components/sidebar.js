import React, {Component} from 'react';
import Graph from "./graph";

export default class sidebar extends Component {
  render() {
    return (

      <div style={{textAlign: 'center'}}>
          <meta name="viewport" content="width=device-width, initial-scale=1" />
          <link rel="stylesheet" href="assets/external.css" />
          <link rel="stylesheet" href="assets/roundImage.css" />

          <div className="w3-sidebar w3-bar-block w3-card" style={{width: '30%', right: 0, overflow:'auto', height:500}}>
            <br/>
              <img src="img_avatar.png" alt="Avatar" style={{width: '100px'}} />
              <br/>
              <h3 className="w3-bar-item" style={{textAlign: 'center'}}>Fernando</h3>
              <h5 className="w3-bar-item" style={{textAlign: 'center'}}>Malabe</h5>
              <br/><br/>
              <div>
                <table style={{width: '100%'}}>
                  <tr>
                    <th>56</th>
                    <th>LKR3542.00</th>
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
                <tr>
                  <td>July 20th</td>
                  <td>Malabe</td>
                  <td>Kandy</td>
                  <td>LKR 125.00</td>
                </tr>
              </table>
              <br/><br/><br/><br/>
          </div>
      </div>
    );
  }
}