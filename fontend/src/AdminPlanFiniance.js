import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";
import Cookies from 'universal-cookie';
import AdminSideBar from "./components/AdminSidebar";

export default class AdminPlanFinance extends Component {
    render() {

        
        const Finances= [
            {id: '001', Amount: '50', Route: 'Kotta-Malabe', Distance: '3', TimeTaken: '40', peak: 'peak', Validity:'valid'},
            {id: '002', Amount: '25', Route: 'Kotta-Nugegoda', Distance: '2', TimeTaken: '20', peak: 'off-peak', Validity:'valid'}
            ]
      
          const FinanceItem = Finances.map((Finances) =>
          <tr>
            <td>{Finances.id}</td>
            <td>{Finances.Amount}</td>
            <td>{Finances.Route}</td>
            <td>{Finances.Distance}km</td>
            <td>{Finances.TimeTaken}min</td>
            <td>{Finances.peak}</td>
            <td>{Finances.Validity}</td>
          </tr>
          );

        return(
            <div>
                    <AdminNavbar/>

                    <br/><br/><br/><br/><br/>
                    <div style={{textAlign: 'center'}}>

                        <AdminSideBar/>   

                        <h3 style={{textAlign:'center', color:'blue'}}>Plan Finances</h3>
                        <br/> <br/>

                        <table style={{margin: '0 auto', width:'70%'}}>
                        <tr style={{backgroundColor:'#e0efed'}}>
                            <th>ID</th>
                            <th>Amount</th>
                            <th>Route</th>
                            <th>Distance</th>
                            <th>Time Taken</th>
                            <th>Peak/Off-peak</th>
                            <th>Validity</th>
                        </tr>
                        <br/>
                        {FinanceItem}
                    </table>

                    <br/> <br/> <br/> <br/> <br/>
                    <button style={{backgroundColor:'white',color:'blue', padding: '20px 80px'}}>Generate Report</button>  

                    </div>


            </div>
        );
    }}