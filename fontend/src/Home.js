import React, {Component} from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import Cookies from 'universal-cookie';

import Sidebar from "./components/sidebar";
import CreditCardDetails from "./components/creditCardDetails";
import OtherOperations from "./components/OtherOperations";
import BlueGradientbar from "./components/BlueGradientBar";
import LoginPage from "./LoginPage";
import AddCredit from "./AddCredit";
import RegisterPage from "./RegisterPage";
import Navbar from "./components/NavBar";

import "bootstrap/dist/css/bootstrap.min.css";

const cookies = new Cookies();
const userDetails = new Cookies();


const UmvValidator = (actions) => {
    const expiryTime = localStorage.getItem('expiryTime');
    const init = localStorage.getItem('init');
    if (!expiryTime && init) {
        
        localStorage.setItem('init',1)
        cookies.set('page', 'login', { path: '/' });
        userDetails.set('username', null, { path: '/' });
    }
}

export default class Home extends Component {
    
    addCredit()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'addCredit');
        window.location.reload();  
    }
    

    render() {
        if (cookies.get('page') == "home") {
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
        } else if (cookies.get('page') == "register") {
            return(
                <div>
                    <RegisterPage/>
                </div>
            );
        } else if (cookies.get('page') == "addCredit") {
            return(
                <div>
                    <AddCredit/>
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
