import React, {Component} from 'react';

import Cookies from 'universal-cookie';
import "bootstrap/dist/css/bootstrap.min.css";



export default class AdminSidebar extends Component {

    constructor() {
        super();
        const userDetails = new Cookies();
        this.state = {
          name: userDetails.get('username')
        };
    }

    render() {
        return(
                <div style={{float: 'right', width: '200px',border:'1px solid black', padding: '5px', marginRight:'5px'}} >
                    <img src="img_avatar.png" alt="Avatar" style={{width: '50px',float:'left'}} />
                    <p>logged in as <br/> {this.state.name}</p>
                </div>
        );
    }}