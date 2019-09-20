import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";

import AdminSideBar from "./components/AdminSidebar";

export default class AdminOverCrowd extends Component {
    render() {

        const Buses= [
            {id: 'b001', Route: 'Malabe-Kaduwela', Seats: '64', Passengers: '120'},
            {id: 'b002', Route: 'galle-Jaffna', Seats: '53', Passengers: '89'}
            ]
      
          const BusItems = Buses.map((Buses) =>
          <tr>
            <td>{Buses.id}</td>
            <td>{Buses.Route}</td>
            <td>{Buses.Seats}</td>
            <td>{Buses.Passengers}</td>
          </tr>
          );


        return(
            <div>
                    <AdminNavbar/>
                    <br/><br/><br/><br/><br/>
                    <div style={{textAlign: 'center'}}>
                    <AdminSideBar/>

                    <h2 style={{color:'#03a9fc'}}>Overcrowd Identify</h2>
                    <br/><br/><br/><br/><br/>
                    <table style={{float:'left', textAlign:'center' , width:'50%', marginLeft:'10px'}}>
                        <tr style={{backgroundColor:'#e0efed'}}>
                            <th>busID</th>
                            <th>Route</th>
                            <th>noOfSeats</th>
                            <th>noOfPassengers</th>
                        </tr>
                        <br/>
                        {BusItems}
                    </table>

                    <div style={{float:'right', textAlign:'center', marginRight:'150px'}}>
                        <h5>Ride Details</h5>
                        <br/>
                        <table>
                            <tr>
                                <td><p>Bus ID: </p></td>
                                <td><input type="text" name="busid"/></td> 
                            </tr>
                            <tr>
                                <td><p>Route: </p></td>
                                <td><input type="text" name="route"/></td> 
                            </tr>
                            <tr>
                                <td><p>Distance: </p></td>
                                <td><input type="text" name="distance"/></td> 
                            </tr>
                            <tr>
                                <td><p>Buses on the Route: </p></td>
                                <td><input type="text" name="busOnRoute"/></td> 
                            </tr>
                        </table>

                    </div>


                        


                    </div>


            </div>
        );
    }}