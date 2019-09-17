import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";

import Sidebar from "./components/sidebar";
import CreditCardDetails from "./components/creditCardDetails";
import OtherOperations from "./components/OtherOperations";
import BlueGradientbar from "./components/BlueGradientBar";
import LoginPage from "./LoginPage";
import AddCredit from "./AddCredit";
import RegisterPage from "./RegisterPage";
import Navbar from "./components/NavBar";

import "bootstrap/dist/css/bootstrap.min.css";

var loggedin = false;
var pageName = "register";


export default class Home extends Component {
    render() {
        if (pageName == "home") {
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
                                    <br/>
                                    <Link to="/AddCredit" className="nav-link">
                                        <div className="mbr-section-btn"><a className="btn btn-md btn-primary display-4" >Add Credit</a></div>
                                    </Link>
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
        } else if (pageName == "login") {
            return(
                <div>
                    <LoginPage/>
                </div>
            );
        } else if (pageName == "register") {
            return(
                <div>
                    <RegisterPage/>
                </div>
            );
        } else if (pageName == "addCredit") {
            return(
                <div>
                    <AddCredit/>
                </div>
            );
        }
        

    }
}
