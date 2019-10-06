import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";

import AdminSideBar from "./components/AdminSidebar";

export default class AddBus extends Component {

    constructor(){
        super();
        this.state = {
            busid: null,
            route: null,
            seats : null,
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

        this.addBusDetails = this.addBusDetails.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.getDetails = this.getDetails.bind(this);
        this.getDetails();
    }

    async getDetails()
  {  
    //Getting user's journey history from backend
    var details = await fetch(`/getAllBusDetails`)
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

    handleChange({ target }) {
        this.setState({
          [target.name]: target.value
        });
      }

      async addBusDetails(event)
      { 
          if(this.state.busid != null)
          {  
              //Sending form data to backend
              event.preventDefault();
              var details = [this.state.busid,this.state.seats,this.state.route];
              var successful = false;
              console.log(`${details}`)
              successful = await fetch(`/addNewBuss?busDetails=${details}`)
                              .then(function(response){ return response.json(); })
                              .then(function(data) {
                                  return data;
                              });
  
              if(successful)
              {
                  alert('Bus Added Successfully');
                  window.location.reload();
              }
              else
              {
                  alert('Error Occured');
              }
          }
          else
          {
              alert('Please fill all fields');
          }
      }  

    render() {

        const Buses= [
            {id: this.state.JourneyHis0[0], Route: this.state.JourneyHis0[1], Seats: this.state.JourneyHis0[2]},
            {id: this.state.JourneyHis1[0], Route: this.state.JourneyHis1[1], Seats: this.state.JourneyHis1[2]},
            {id: this.state.JourneyHis2[0], Route: this.state.JourneyHis2[1], Seats: this.state.JourneyHis2[2]},
            {id: this.state.JourneyHis3[0], Route: this.state.JourneyHis3[1], Seats: this.state.JourneyHis3[2]},
            {id: this.state.JourneyHis4[0], Route: this.state.JourneyHis4[1], Seats: this.state.JourneyHis4[2]},
            {id: this.state.JourneyHis5[0], Route: this.state.JourneyHis5[1], Seats: this.state.JourneyHis5[2]},
            {id: this.state.JourneyHis6[0], Route: this.state.JourneyHis6[1], Seats: this.state.JourneyHis6[2]},
            {id: this.state.JourneyHis7[0], Route: this.state.JourneyHis7[1], Seats: this.state.JourneyHis7[2]},
            {id: this.state.JourneyHis8[0], Route: this.state.JourneyHis8[1], Seats: this.state.JourneyHis8[2]},
            {id: this.state.JourneyHis9[0], Route: this.state.JourneyHis9[1], Seats: this.state.JourneyHis9[2]},
          ]
      
          const BusItems = Buses.map((Buses) =>
          <tr>
            <td>{Buses.id}</td>
            <td>{Buses.Route}</td>
            <td>{Buses.Seats}</td>
          </tr>
          );

        return(
            <div>
                    <AdminNavbar/>
                    <br/><br/><br/><br/><br/>
                    <div style={{textAlign: 'center'}}>
                    <AdminSideBar/>
                    <div style={{float:'right',textAlign:'center', marginRight:'150px'}}>
                        <h5>Add New Bus</h5>
                        <br/>
                        <table style={{margin:'0 auto'}}>
                            <tr>
                                <td><p>Bus ID: </p></td>
                                <td><input type="text" name="busid" value={ this.state.busid } onChange={ this.handleChange }/></td> 
                            </tr>
                            <tr>
                                <td><p>Route: </p></td>
                                <td><input type="text" name="route" value={ this.state.route } onChange={ this.handleChange }/></td> 
                            </tr>
                            <tr>
                                <td><p>Seats: </p></td>
                                <td><input type="text" name="seats" value={ this.state.seats } onChange={ this.handleChange }/></td> 
                            </tr>
                            <tr>
                            <button className="btn btn-sm btn-primary display-4" href="#" style={{marginLeft:'0px'}} onClick={this.addBusDetails}>Add</button>
                            </tr>
                        </table>

                    </div>
                    <br/><br/>
                    
                    <table style={{float:'left', textAlign:'center' , width:'50%', marginLeft:'10px'}}>
                        <tr style={{backgroundColor:'#e0efed'}}>
                            <th>busID</th>
                            <th>Route</th>
                            <th>noOfSeats</th>
                        </tr>
                        <br/>
                        {BusItems}
                    </table>
                    <br/><br/><br/><br/><br/>

                        


                    </div>


            </div>
        );
    }}