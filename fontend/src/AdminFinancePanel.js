import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";
import Cookies from 'universal-cookie';
import AdminSideBar from "./components/AdminSidebar";

export default class AdminPanel extends Component {

    planFinance()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'planFinance');
        window.location.reload();  
    }

    unauthorizedTravels()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'unauthorizedTravels');
        window.location.reload();  
    }
    render() {
        return(
            <div>
                    <AdminNavbar/>

                    <br/><br/><br/><br/><br/>
                    <div style={{textAlign: 'center'}}>

                        <AdminSideBar/>

                        <table style={{textAlign:'center', width: '100%'}}>
                            <tr>
                                <button onClick={this.planFinance} style={{backgroundColor:'white',color:'blue', padding: '20px 80px'}}>Plan Finances</button>  
                            </tr>
                            <br/>
                            <tr>
                            <button onClick={this.unauthorizedTravels} style={{backgroundColor:'white', color:'blue', padding: '20px 80px'}}>Check Unauthorized Travels</button>  
                            </tr>
                        </table>


                    </div>


            </div>
        );
    }}