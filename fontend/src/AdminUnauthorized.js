import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";
import Cookies from 'universal-cookie';
import AdminSideBar from "./components/AdminSidebar";
import Graph from "./components/UnauthorizedGraph";

export default class AdminUnauthorized extends Component {
    render() {

        
        const Travels= [
            {id: '001', Fair: '25', Route: 'Colombo-Kandy', Distance: '70', TokenStatus: 'invalid', Month: 'January'},
            {id: '002', Fair: '12', Route: 'Malabe-Pitakotte', Distance: '3.2', TokenStatus: 'invalid', Month: 'February'}
            ]
      
          const TravelItems = Travels.map((Travels) =>
          <tr>
            <td>{Travels.Fair}</td>
            <td>{Travels.Route}</td>
            <td>{Travels.Distance}km</td>
            <td>{Travels.TokenStatus}</td>
            <td>{Travels.Month}</td>
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
                            <th>Fair</th>
                            <th>Route</th>
                            <th>Distance</th>
                            <th>Token Status</th>
                            <th>Month</th>
                        </tr>
                        <br/>
                        {TravelItems}
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