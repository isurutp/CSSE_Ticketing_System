import React, {Component} from 'react';

import Background from './images/forestbridge.jpg';

import "bootstrap/dist/css/bootstrap.min.css";
import Cookies from 'universal-cookie';

export default class LoginPage extends Component {

    constructor() {
        super();
        this.state = {
          name: null,
          password: null
        };
    
        this.register = this.register.bind(this);
        this.login = this.login.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    register()
    {
        const cookies = new Cookies();
        cookies.get('page');
        cookies.set('page', 'register');
        window.location.reload();  
    }

    async login(event)
    {
        const cookies = new Cookies();
        cookies.get('page');

        const userDetails = new Cookies();
        userDetails.get('username');
        userDetails.set('username', this.state.name);
        userDetails.set('creditBalance', 1723.51);

        if(this.state.name === 'admin')
        {
            cookies.set('page', 'admin');
            window.location.reload(); 
            return;
        }

        if(this.state.name != null)
        {

            //Sending form data to backend
            event.preventDefault();
            var details = [this.state.name, this.state.password];
            var successful = false;
            successful = await fetch(`/login?userDetails=${details}`)
                            .then(function(response){ return response.json(); })
                            .then(function(data) {
                                return data;
                            });

            if(successful)
            {
                cookies.set('page', 'home');
                window.location.reload();  
            }
            else
            {
                alert('Incorrect Login details');
            }
        }
        else
        {
            alert('Please fill both fields');
        }
    }

    handleChange({ target }) {
        this.setState({
          [target.name]: target.value
        });
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
                        <h1>Login</h1> 
                        <br/>
                        <table style={{height:"100px", width:"100px", margin: "0 auto"}}>
                            <tr>
                                <td><p>Username: </p></td>
                                <td><input type="text" name="name" value={ this.state.name } onChange={ this.handleChange } /></td> 
                            </tr>
                            <tr>
                                <td><p>Password: </p></td>
                                <td><input type="password" name="password" value={ this.state.password } onChange={ this.handleChange } /></td> 
                            </tr>
                        </table>
                        <br/>
                        <button className="btn btn-md btn-primary display-4" style={{float:"left"}} onClick={this.register}>Register</button>
                        <button className="btn btn-md btn-primary display-4" style={{float:"right"}} onClick={this.login}>login</button>
                    </div>
                </div>
            </section>
        );
    }
}
