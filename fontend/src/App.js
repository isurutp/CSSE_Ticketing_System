import React from 'react';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import Home from "./Home";
import AddCredit from "./AddCredit";

import "bootstrap/dist/css/bootstrap.min.css";


function App() {
      return (
        <div>
          <Router>
          {/* Linking External Sources */}
          <meta httpEquiv="X-UA-Compatible" content="IE=edge" />
          <meta name="generator" content="Mobirise v4.10.8, mobirise.com" />
          <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1" />
          <link rel="shortcut icon" href="assets/images/mbr-122x122.jpg" type="image/x-icon" />
          <meta name="description" content />
          <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css" />
          <link rel="stylesheet" href="assets/tether/tether.min.css" />
          <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
          <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css" />
          <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css" />
          <link rel="stylesheet" href="assets/dropdown/css/style.css" />
          <link rel="stylesheet" href="assets/theme/css/style.css" />
          <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css" />
          
          
          <Home/>
            <Switch>
              <Route path="/AddCredit" component={AddCredit}/>
            </Switch>
          </Router>
        </div>        
      );
}

export default App;

