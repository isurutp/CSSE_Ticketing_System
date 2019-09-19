import React, {Component} from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

import BlueGradientbar from "./components/BlueGradientBar";
import Navbar from "./components/NavBar";

export default class CreditHistory extends Component {
    render() {
        return(
            <div>
                <Navbar/>
                <section className="header1 cid-rB4qRp8JKI" id="header16-2" style={{height:'350px'}}>
                    <BlueGradientbar/>
                    <br/><br/>                       
                    <h4 style={{textAlign: 'center'}} >My Credit</h4>
                </section>

            <br/><br/>
            <table style={{textAlign:'center', width: '80%'}}>
                <tr style={{color:'blue'}}>
                  <th>Date</th>
                  <th>Amount</th>
                </tr>
                <br/>
                <tr>
                  <td>01-07-2019</td>
                  <td>1500.00</td>
                </tr>
                <br/>
                <tr>
                  <td>15-07-2019</td>
                  <td>550.00</td>
                </tr>
                <br/>
                <tr>
                  <td>27-07-2019</td>
                  <td>1000.00</td>
                </tr>
              </table>
                
                













            </div>
        );
    }}