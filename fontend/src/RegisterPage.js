import React, {Component} from 'react';

import Background from './images/forestbridge.jpg';

import "bootstrap/dist/css/bootstrap.min.css";

export default class RegisterPage extends Component {

    constructor() {
        super();
        this.state = {
          name: null,
          nic: null,
          address: null,
          dob: null
        };
    
        this.registerUser = this.registerUser.bind(this);
        this.handleChange = this.handleChange.bind(this);

        this.json = {}
    }

    handleChange({ target }) {
        this.setState({
          [target.name]: target.value
        });
      }

    registerUser()
    {
        const SAMPLE_JSON = {   
                                name: this.name, 
                                nic: this.nic,
                                address: this.address,
                                dob: this.dob                                
                            }
        const json = window.localStorage.getItem('someJson') || JSON.stringify(SAMPLE_JSON, null, 2)
        this.setState({ json })
        const validJson = JSON.stringify(JSON.parse(this.state.json), null, 2)
                                
        window.localStorage.setItem(
            'someJson',
            validJson
            )
        alert('HELLO');
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
                        <table style={{height:"100px", width:"120px"}}>
                            <tr>
                                <td><p>Username: </p></td>
                                <td><input type="text" name="name" required value={ this.state.name } onChange={ this.handleChange }/></td> 
                            </tr>
                            <tr>
                                <td><p>NIC: </p></td>
                                <td><input type="text" name="nic" required value={ this.state.nic } onChange={ this.handleChange }/></td>
                            </tr>
                            <tr>
                                <td><p>Address: </p></td>
                                <td><input type="text" name="address" required value={ this.state.address } onChange={ this.handleChange }/></td>
                            </tr>
                            <tr>
                                <td><p>Date of Birth: </p></td>
                                <td><input type="date" name="dob" value="1990-01-01" required value={ this.state.dob } onChange={ this.handleChange }/></td>
                            </tr>
                        </table>
                        <br/>
                        <div className="mbr-section-btn">
                            <button className="btn btn-md btn-primary display-4" style={{float:"right"}} onClick={this.registerUser}>Submit</button>
                        </div>
                    </div>
                </div>
            </section>
        );
    }
}
