import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import Cookies from 'universal-cookie';

import Sidebar from "./components/sidebar";
import CreditCardDetails from "./components/CreditCardDetails";
import OtherOperations from "./components/OtherOperations";
import BlueGradientbar from "./components/BlueGradientBar";
import Navbar from "./components/NavBar";

import LoginPage from "./LoginPage";
import AddCredit from "./AddCredit";
import RegisterPage from "./RegisterPage";
import CreditHistory from "./CreditHistory";
import Admin from "./AdminPanel";
import AdminOvercrowd from "./AdminOverCrowd";
import AdminTimetable from "./AdminTimetable";
import AdminCountDetails from "./AdminCountDetails";
import AdminFinancePanel from "./AdminFinancePanel";

import "bootstrap/dist/css/bootstrap.min.css";

const cookies = new Cookies();


// const UmvValidator = (actions) => {
//     const expiryTime = localStorage.getItem('expiryTime');
//     const init = localStorage.getItem('init');
//     if (once) {
        
//         localStorage.setItem('init',1)
//         cookies.set('page', null, { path: '/' });
//         userDetails.set('username', null, { path: '/' });
//         userDetails.set('creditBalance', 1723.51);
//         once = false;
//     }
// }

export default class Home extends Component {
    
    addCredit()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'addCredit');
        window.location.reload();  
    }
    

    render() {
        if (cookies.get('page') === "home") {
            return(
                <Router>
                    <div>
                        <Navbar/>
                        <section className="header1 cid-rB4qRp8JKI" id="header16-2">
                        <BlueGradientbar/>
                        <div className="container">
                            <Sidebar/>
                            <div className="row justify-content-md-center">
                                <div className="col-md-10 align-center">
                                    <br/><br/><br/>
                                        <div className="mbr-section-btn">
                                            <button className="btn btn-md btn-primary display-4" onClick={this.addCredit}>Add Credit</button>
                                        </div>
                                </div>
                            </div>
                        </div>
                        </section>
                        <CreditCardDetails/>
                        <br/>
                        <OtherOperations/>
                    </div>
                    </Router>
            );
        } else if (cookies.get('page') === "register") {
            return(
                <div>
                    <RegisterPage/>
                </div>
            );
        } else if (cookies.get('page') === "addCredit") {
            return(
                <div>
                    <AddCredit/>
                </div>
            );
        }else if (cookies.get('page') === "creditHistory") {
        return(
            <div>
                <CreditHistory/>
            </div>
        );
    }else if (cookies.get('page') === "admin") {
        return(
            <div>
                <Admin/>
            </div>
        );
    }else if (cookies.get('page') === "adminOverCrowd") {
        return(
            <div>
                <AdminOvercrowd/>
            </div>
        );
    }else if (cookies.get('page') === "adminTimetable") {
        return(
            <div>
                <AdminTimetable/>
            </div>
        );
    }else if (cookies.get('page') === "adminCountDetails") {
        return(
            <div>
                <AdminCountDetails/>
            </div>
        );
    }else if (cookies.get('page') === "adminFinancePanel") {
        return(
            <div>
                <AdminFinancePanel/>
            </div>
        );
    }

    else{
        return(
            <div>
                <LoginPage/>
            </div>
        );
    } 

        

    }
}
