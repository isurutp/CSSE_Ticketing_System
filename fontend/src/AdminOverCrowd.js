import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";

import AdminSideBar from "./components/AdminSidebar";

export default class AdminOverCrowd extends Component {

    constructor() {
        super();
        this.state = {
          JourneyHis0: ["","","",""],
          JourneyHis1: ["","","",""],
          JourneyHis2: ["","","",""],
          JourneyHis3: ["","","",""],
          JourneyHis4: ["","","",""],
          JourneyHis5: ["","","",""],
          JourneyHis6: ["","","",""],
          JourneyHis7: ["","","",""],
          JourneyHis8: ["","","",""],
          JourneyHis9: ["","","",""],
        };
    this.getDetails = this.getDetails.bind(this);
    this.getDetails();
    
}

async getDetails()
  {  
    //Getting user's journey history from backend
    var details = await fetch(`/getOCBusDetails`)
    .then(function(response){ return response.text(); })
  
    if(!details.includes("error"))
    {
      var myArray = details.split('],[');
      var result = ["","","","","","","","","",""]
      for(var i=0;i<10;i++)
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
    this.setState({JourneyHis4: result[4]});
    this.setState({JourneyHis5: result[5]});
    this.setState({JourneyHis6: result[6]});
    this.setState({JourneyHis7: result[7]});
    this.setState({JourneyHis8: result[8]});
    this.setState({JourneyHis9: result[9]});
    }
  }



    render() {

        const Buses= [
            {id: this.state.JourneyHis0[0], Route: this.state.JourneyHis0[1], Seats: this.state.JourneyHis0[2], Passengers: this.state.JourneyHis0[3]},
            {id: this.state.JourneyHis1[0], Route: this.state.JourneyHis1[1], Seats: this.state.JourneyHis1[2], Passengers: this.state.JourneyHis1[3]},
            {id: this.state.JourneyHis2[0], Route: this.state.JourneyHis2[1], Seats: this.state.JourneyHis2[2], Passengers: this.state.JourneyHis2[3]},
            {id: this.state.JourneyHis3[0], Route: this.state.JourneyHis3[1], Seats: this.state.JourneyHis3[2], Passengers: this.state.JourneyHis3[3]},
            {id: this.state.JourneyHis4[0], Route: this.state.JourneyHis4[1], Seats: this.state.JourneyHis4[2], Passengers: this.state.JourneyHis4[3]},
            {id: this.state.JourneyHis5[0], Route: this.state.JourneyHis5[1], Seats: this.state.JourneyHis5[2], Passengers: this.state.JourneyHis5[3]},
            {id: this.state.JourneyHis6[0], Route: this.state.JourneyHis6[1], Seats: this.state.JourneyHis6[2], Passengers: this.state.JourneyHis6[3]},
            {id: this.state.JourneyHis7[0], Route: this.state.JourneyHis7[1], Seats: this.state.JourneyHis7[2], Passengers: this.state.JourneyHis7[3]},
            {id: this.state.JourneyHis8[0], Route: this.state.JourneyHis8[1], Seats: this.state.JourneyHis8[2], Passengers: this.state.JourneyHis8[3]},
            {id: this.state.JourneyHis9[0], Route: this.state.JourneyHis9[1], Seats: this.state.JourneyHis9[2], Passengers: this.state.JourneyHis9[3]},
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