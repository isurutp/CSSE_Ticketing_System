import React, {Component} from 'react';

import Background from './images/forestbridge.jpg';
import Cookies from 'universal-cookie';

import "bootstrap/dist/css/bootstrap.min.css";

export default class RegisterPage extends Component {

    constructor() {
        super();
        this.state = {
          name: null,
          nic: null,
          password: null,
          password2: null,
          address: null,
          dob: "1990-01-01"
        };
    
        this.registerUser = this.registerUser.bind(this);
        this.handleChange = this.handleChange.bind(this);

    }

    handleChange({ target }) {
        this.setState({
          [target.name]: target.value
        });
      }

    async registerUser(event)
    { 
        if(this.state.name != null)
        {

            if(this.state.password != this.state.password2)
            {
                alert('Passwords do not match');
                return;
            }

            //Sending form data to backend
            event.preventDefault();
            var details = [this.state.name,this.state.nic,this.state.address,this.state.dob,this.state.password];
            var successful = false;
            successful = await fetch(`/register?userDetails=${details}`)
                            .then(function(response){ return response.json(); })
                            .then(function(data) {
                                return data;
                            });

            if(successful)
            {
                const cookies = new Cookies();
                cookies.get('page');
                cookies.set('page', 'login');
                alert('Please confirm Registration by clicking the link in your email');
                window.location.reload();  
            }
            else
            {
                alert('Something went wrong, unable to create account');
            }
        }
        else
        {
            alert('Please fill all fields');
        }
    }

    cancel()
    {
            const cookies = new Cookies();
            cookies.get('page');
            cookies.set('page', 'login');
            window.location.reload();  
    }

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
                        <h1>Register</h1> 
                        <br/>
                            <table style={{height:"100px"}}>
                                <tr>
                                    <td><p>Username: </p></td>
                                    <td><input type="text" name="name" value={ this.state.name } onChange={ this.handleChange }/></td> 
                                </tr>
                                <tr>
                                    <td><p>Password: </p></td>
                                    <td><input type="password" name="password" value={ this.state.password } onChange={ this.handleChange }/></td> 
                                </tr>
                                <tr>
                                    <td><p>Confirm Password: </p></td>
                                    <td><input type="password" name="password2" value={ this.state.password2 } onChange={ this.handleChange }/></td> 
                                </tr>
                                <tr>
                                    <td><p>NIC: </p></td>
                                    <td><input type="text" name="nic" value={ this.state.nic } onChange={ this.handleChange }/></td>
                                </tr>
                                <tr>
                                    <td><p>City: </p></td>
                                    <td><input type="text" name="address" value={ this.state.address } onChange={ this.handleChange }/></td>
                                </tr>
                                <tr>
                                    <td><p>Date of Birth: </p></td>
                                    <td><input type="date" name="dob" value={ this.state.dob } onChange={ this.handleChange }/></td>
                                </tr>
                            </table>
                        <br/>
                        <div className="mbr-section-btn">
                        <button className="btn btn-md btn-primary display-4" style={{float:"left"}} onClick={this.cancel}>Cancel</button>
                            <button className="btn btn-md btn-primary display-4" style={{float:"right"}} onClick={this.registerUser}>Submit</button>
                        </div>
                    </div>
                </div>
            </section>
        );
    }
}
