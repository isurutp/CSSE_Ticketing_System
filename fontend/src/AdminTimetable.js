import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";

import AdminSideBar from "./components/AdminSidebar";

export default class AdminTimetable extends Component {
    render() {
        return(
            <div>
                    <AdminNavbar/>
                    <br/><br/><br/><br/><br/>
                    <div style={{textAlign: 'center'}}>
                    <AdminSideBar/>

                    <h2 style={{color:'#03a9fc'}}>Plan Timetables</h2>
                    <br/><br/><br/><br/><br/>
                    <table style={{float:'left', textAlign:'center' , width:'50%', marginLeft:'10px'}}>
                        <tr style={{backgroundColor:'#e0efed'}}>
                            <th>ID</th>
                            <th>Journey Time (hrs)</th>
                            <th>Starting Point</th>
                            <th>Ending Point</th>
                        </tr>
                        <br/>
                        <tr>
                            <td>r001</td>
                            <td>02</td>
                            <td>Kaduwela</td>
                            <td>Malabe</td>
                        </tr>
                        <tr>
                            <td>r002</td>
                            <td>03</td>
                            <td>Moratuwa</td>
                            <td>Malabe</td>
                        </tr>
                    </table>

                    <div style={{float:'right', textAlign:'center', marginRight:'150px'}}>
                        <h5>Ride Details</h5>
                        <br/>
                        <table>
                            <tr>
                                <td><p>ID: </p></td>
                                <td><input type="text" name="id"/></td> 
                            </tr>
                            <tr>
                                <td><p>Route: </p></td>
                                <td><input type="text" name="route"/></td> 
                            </tr>
                            <tr>
                                <td><p>Time taken: </p></td>
                                <td><input type="text" name="timeTaken"/></td> 
                            </tr>
                            <tr>
                                <td><p>Buses on the Route: </p></td>
                                <td><input type="text" name="busOnRoute"/></td> 
                            </tr>
                        </table>
                        <br/>
                        <button style={{backgroundColor:'white',color:'blue' , padding: '5px 60px'}} >save</button>

                    </div>



                </div>


            </div>
        );
    }}