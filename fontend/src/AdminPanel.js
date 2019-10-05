import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";
import Cookies from 'universal-cookie';
import AdminSideBar from "./components/AdminSidebar";

export default class AdminPanel extends Component {

    overCrowd()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'adminOverCrowd');
        window.location.reload();  
    }

    timetable()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'adminTimetable');
        window.location.reload();  
    }

    countDetails()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'adminCountDetails');
        window.location.reload();  
    }

    addBus(){
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'addBus');
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
                                <button onClick={this.timetable} style={{backgroundColor:'yellow', padding: '20px 80px'}}>Plan Time Tables</button>  
                            </tr>
                            <br/>
                            <tr>
                            <button onClick={this.overCrowd} style={{backgroundColor:'#4CAF50', padding: '20px 80px'}}>Overcrowd Details</button>  
                            </tr>
                            <br/>
                            <tr>
                            <button onClick={this.countDetails} style={{backgroundColor:'#33ccff', padding: '20px 80px'}}>Passenger Count Details</button> 
                            </tr>
                            <br/>
                            <tr>
                            <button onClick={this.addBus} style={{backgroundColor:'#33ccff', padding: '20px 80px'}}>Add Bus</button> 
                            </tr>

                        </table>


                    </div>


            </div>
        );
    }}