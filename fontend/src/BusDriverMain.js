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
            type: 'card',
            crrJourney: [],
            selectedUser: ''
        };

        this.addUser = this.addUser.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.setData = this.setData.bind(this);
        this.setData();
        this.endJourney = this.endJourney.bind(this);
    }

    async endJourney({target}){
        this.setState([
            this.state.selectedUser = target.value
        ]);
        var deleteUser = false;
        deleteUser = await fetch(`/deleteOneCurrentJourney?username=${this.state.selectedUser}`)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {
                return data;
            });
        if(deleteUser){
            alert('Deleted the user ' + this.state.selectedUser + ' from journey list') ;
            //Add user details to the ride list
            window.location.reload();
            return ;
        }else{
            alert(this.state.selectedUser + ' Not found');
            return ;
        }
    }

    async setData() {
        const cookies = new Cookies();
        var bName = cookies.get('username') ;
        var jData = await fetch(`/getCurrentJourneyDetails?busId=${bName}`)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {
                return data;
            });
        for (var i=0; i<jData.length ; i++){
            this.setState([
                this.state.crrJourney[i] = jData[i]
            ]);
        }
    }

    handleChange({ target }) {
        this.setState({
            [target.name]: target.value
        });
    }

    async addUser() {
        const cookies = new Cookies();
        cookies.get('page');

        var bName = cookies.get('username') ;
        var pName = this.state.name ;
        var pType = this.state.type ;

        if (pName == null){
            alert('Please enter passenger username');
            return;
        }

        var valid = false ;
        if (pType!='temporary'){
            valid = await fetch(`/checkPassengerDetails?username=${pName}`)
                .then(function(response){ return response.json(); })
                .then(function(data){
                    return data;
                });
           if(valid){
               var creditBalance = await fetch(`/getAmount?username=${pName}`)
                   .then(function(response){ return response.json(); })
                   .then(function(data){
                       return data;
                   });
               if (creditBalance >= 100){
                   alert('Username : ' + pName +'\nCredit balance Rs.'+ creditBalance);
               }else{
                   alert('Insufficient credit\nCurrent Balance Rs.' + creditBalance + '\nCurrent balance must be at least Rs.100');
                   return ;
               }
           }
        }else{
            //**********************************************************************************************************
            //Add a method to find if the temporary token is valid
            //**********************************************************************************************************
            valid = true;
        }

        if (valid) {
            var journey = false ;
                journey = await fetch(`/addNewUserToJourney?busId=${bName}&username=${pName}&payment=${pType}`)
                    .then(function (response) {
                        return response.json();
                    })
                    .then(function (data) {
                        return data;
                    });
                if(journey){
                    alert('Successfully added to journey');
                    window.location.reload();
                    return ;
                }else{
                    alert('User is already in the journey');
                    return;
                }
        }
        alert('Invalid username');
    }

    render() {
        const PassItemsNew = this.state.crrJourney.map((journey,i) =>
            <tr>
                <td>{this.state.crrJourney[i][1]}</td>
                <td>{this.state.crrJourney[i][2]}</td>
                <td>{this.state.crrJourney[i][3]}</td>
                <td><button value={this.state.crrJourney[i][1]} name={'selectedUser'} onClick={this.endJourney}>End</button></td>
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
                            <th>Start Time</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        {PassItemsNew}
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