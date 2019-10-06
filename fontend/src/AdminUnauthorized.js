import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";
import AdminSideBar from "./components/AdminSidebar";
import Graph from "./components/UnauthorizedGraph";

export default class AdminUnauthorized extends Component {

    constructor(){
        super();
        this.state = {
            name: null,
            date: null,
            route : null,
            fare : null,
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
    var details = await fetch(`/getAllUnauthorizedTravelss`)
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

        
        const Unauthorized= [
            {name: this.state.JourneyHis0[0], date: this.state.JourneyHis0[2], route: this.state.JourneyHis0[3], fare: this.state.JourneyHis0[4]},
            {name: this.state.JourneyHis1[0], date: this.state.JourneyHis1[2], route: this.state.JourneyHis1[3], fare: this.state.JourneyHis1[4]},
            {name: this.state.JourneyHis2[0], date: this.state.JourneyHis2[2], route: this.state.JourneyHis2[3], fare: this.state.JourneyHis2[4]},
            {name: this.state.JourneyHis3[0], date: this.state.JourneyHis3[2], route: this.state.JourneyHis3[3], fare: this.state.JourneyHis3[4]},
            {name: this.state.JourneyHis4[0], date: this.state.JourneyHis4[2], route: this.state.JourneyHis4[3], fare: this.state.JourneyHis4[4]},
            {name: this.state.JourneyHis5[0], date: this.state.JourneyHis5[2], route: this.state.JourneyHis5[3], fare: this.state.JourneyHis5[4]},
            {name: this.state.JourneyHis6[0], date: this.state.JourneyHis6[2], route: this.state.JourneyHis6[3], fare: this.state.JourneyHis6[4]},
            {name: this.state.JourneyHis7[0], date: this.state.JourneyHis7[2], route: this.state.JourneyHis7[3], fare: this.state.JourneyHis7[4]},
            {name: this.state.JourneyHis8[0], date: this.state.JourneyHis8[2], route: this.state.JourneyHis8[3], fare: this.state.JourneyHis8[4]},
            {name: this.state.JourneyHis9[0], date: this.state.JourneyHis9[2], route: this.state.JourneyHis9[3], fare: this.state.JourneyHis9[4]},
          ]
      
          const UnauthorizedItems = Unauthorized.map((Unauthorized) =>
          <tr>
            <td>{Unauthorized.name}</td>
            <td>{Unauthorized.date}</td>
            <td>{Unauthorized.route}</td>
            <td>{Unauthorized.fare}</td>
          </tr>
          );

        return(
            <div>
                    <AdminNavbar/>

                    <br/><br/><br/><br/><br/>
                    <div>

                        <AdminSideBar/>   

                        <h3 style={{textAlign:'center', color:'blue'}}>Unauthorized Travels</h3>
                        <br/> <br/>

                        <table style={{float:'left', width:'50%',marginLeft:'25px'}}>
                        <tr style={{backgroundColor:'#e0efed'}}>
                            <th>Name</th>
                            <th>Date</th>
                            <th>Route</th>
                            <th>Fare</th>
                        </tr>
                        <br/>
                        {UnauthorizedItems}
                    </table>
                    <br/><br/>
                    <div style={{float:'right',marginRight:'25px'}}>
                        <Graph/>
                        
                        <br/><br/>
                        <button style={{backgroundColor:'white',color:'blue', padding: '20px 80px'}}>Generate Report</button>  
                    </div>

                    </div>


            </div>
        );
    }}