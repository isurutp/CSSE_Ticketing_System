import React, {Component} from 'react';
import { Switch, Route } from 'react-router-dom'

import Background from './images/forestbridge.jpg';

import "bootstrap/dist/css/bootstrap.min.css";

export default class LoginPage extends Component {

    render() {
        var sectionStyle = {
            backgroundImage: "url(" + Background + ")",
            position: 'fixed',
            top: 0,
            width: '100%',
            height: '100vh'
          };
          var centerStyle = {
            position: "absolute",
            width: "400px",
            height: "500px",
            zIndex: 15,
            top: "50%",
            left: "50%",
            margin: "-100px 0 0 -150px",
            textAlign:"center"
          };

        return(
            <section style={ sectionStyle }>
                <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />


                <div style={{color:'white'}}>
                    <div style={centerStyle}>
                        <h1>Login</h1> 
                        <br/>
                        <table style={{height:"100px", width:"100px"}}>
                            <tr>
                                <td><p>Username: </p></td>
                                <td><input type="text" name="uname" required /></td> 
                            </tr>
                            <tr>
                                <td><p>Password: </p></td>
                                <td><input type="password" name="psw" required /></td> 
                            </tr>
                        </table>
                        <br/>
                        <div className="mbr-section-btn">
                            <a className="btn btn-md btn-primary display-4" style={{float:"left"}}>Register</a>
                            <a className="btn btn-md btn-primary display-4" style={{float:"right"}}>login</a>
                        </div>
                    </div>
                </div>
            </section>
        );
    }
}
