import React, {Component} from 'react';
import { BrowserRouter as Router} from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import Cookies from 'universal-cookie';

import BusNavbar from "./components/BusDriverNavBar";

export default class BusDriverMain extends Component {

    constructor() {
        super();
        this.state = {
            name: null,
            type: 'card'
        };

        this.addUser = this.addUser.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange({ target }) {
        this.setState({
            [target.name]: target.value
        });
    }

    addUser() {
        const cookies = new Cookies();
        cookies.get('page');

        alert('Hello'+ this.state.type ) ;
    }

    render() {
        const Passengers= [
            {username: 'isuru97', type: 'Cash'}
        ]
        const PassItems = Passengers.map((Passengers) =>
            <tr>
                <td>{Passengers.username}</td>
                <td>{Passengers.type}</td>
                <td>null</td>
            </tr>
        );

        return(
            <Router>
            <div>
                <BusNavbar/>
                <br/><br/><br/><br/><br/>
                <div style={{textAlign: 'left', paddingLeft:'40px'}}>

                    <table style={{ width: '100%'}}>
                        <tr>
                            Passenger username <br/>
                            <input type="text" name={"name"} value={this.state.name} onChange={this.handleChange}/>
                        </tr>
                        <tr>
                            Payment type<br/>
                            <select name={"type"} value={this.state.type} onChange={this.handleChange}>
                                <option value={'card'}>Card Payment</option>
                                <option value={'cash'}>Cash Payment</option>
                                <option value={'temporary'}>Temporary</option>
                            </select>
                        </tr>
                        <tr>
                            <button className="btn btn-sm btn-primary display-4" href="#" style={{marginLeft:'0px'}} onClick={this.addUser}>Add</button>
                        </tr>
                        <br/>
                    </table>
                </div>
                <div>
                <div style={{width:'40%', float:'left'}}>
                    <br/>
                    <h4>Journey</h4>
                    <table id={"myTable"} className="table table-striped" style={{marginTop:'10px'}}>
                        <thead>
                        <tr>
                            <th>Passenger</th>
                            <th>Payment Type</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        {PassItems}
                        </tbody>
                    </table>
                </div>
                <div style={{textAlign:'center'}}>
                    <button className="btn btn-sm btn-primary display-4" href="#" style={{marginLeft:'0px'}}>End Journey</button>
                </div>
            </div>
            </div>
            </Router>
        );
    }}