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
            seats : null
        };

        this.addBusDetails = this.addBusDetails.bind(this);
        this.handleChange = this.handleChange.bind(this);
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
        return(
            <div>
                    <AdminNavbar/>
                    <br/><br/><br/><br/><br/>
                    <div style={{textAlign: 'center'}}>
                    <AdminSideBar/>
                    <div style={{float:'right', textAlign:'center', marginRight:'150px'}}>
                        <h5>Add New Bus</h5>
                        <br/>
                        <table>
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


                        


                    </div>


            </div>
        );
    }}