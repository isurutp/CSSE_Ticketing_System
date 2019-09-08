import React from 'react';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";

import Sidebar from "./components/sidebar";
import CreditCardDetails from "./components/creditCardDetails";
import OtherOperations from "./components/OtherOperations";
import Navbar from "./components/NavBar";
import BlueGradientbar from "./components/BlueGradientBar";

import "bootstrap/dist/css/bootstrap.min.css";
import AddCredit from './AddCredit';




function App() {
      return (
        <Router>
          <div>
            {/* Linking External Sources */}
            <meta httpEquiv="X-UA-Compatible" content="IE=edge" />
            <meta name="generator" content="Mobirise v4.10.8, mobirise.com" />
            <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1" />
            <link rel="shortcut icon" href="assets/images/mbr-122x122.jpg" type="image/x-icon" />
            <meta name="description" content />
            <title>Home</title>
            <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css" />
            <link rel="stylesheet" href="assets/tether/tether.min.css" />
            <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
            <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css" />
            <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css" />
            <link rel="stylesheet" href="assets/dropdown/css/style.css" />
            <link rel="stylesheet" href="assets/theme/css/style.css" />
            <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css" />

            <Navbar/>
            
            <section className="header1 cid-rB4qRp8JKI" id="header16-2">
            <BlueGradientbar/>
              <div className="container">
              <Sidebar/>
                <div className="row justify-content-md-center">
                  <div className="col-md-10 align-center">
                    <br/>
                    <Link to="/AddCredit" className="nav-link"><div className="mbr-section-btn"><a className="btn btn-md btn-primary display-4">Add Credit</a></div></Link>
                  </div>
                </div>
              </div>
            </section>
            <CreditCardDetails/>
            <br/>
            <OtherOperations/>
            <Switch>
              <Route path="/AddCredit" component={AddCredit}/>
            </Switch>
          </div>
        </Router>
      );
}

export default App;

