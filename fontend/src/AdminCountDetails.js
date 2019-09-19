import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";
import AdminNavbar from "./components/AdminNavBar";

import AdminSideBar from "./components/AdminSidebar";
import AdminGraph from "./components/AdminGraph";

export default class AdminCountDetails extends Component {
    render() {
        return(
            <div>
                <AdminNavbar/>
                <br/><br/><br/><br/><br/>
                <div style={{textAlign: 'center'}}>
                <AdminSideBar/>

                <br/><br/><br/><br/><br/>

                <AdminGraph/>

                </div>


            </div>
        );
    }}