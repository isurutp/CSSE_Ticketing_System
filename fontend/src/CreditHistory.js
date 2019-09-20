import React, {Component} from 'react';
import "bootstrap/dist/css/bootstrap.min.css";

import BlueGradientbar from "./components/BlueGradientBar";
import Navbar from "./components/NavBar";

export default class CreditHistory extends Component {
    render() {

      const MyCredit= [
        {id: '01', Date: '01-07-2019', Amount: 1500.00},
        {id: '02', Date: '15-07-2019', Amount: 550.00},
        {id: '03', Date: '27-07-2019', Amount: 1000.00}
        ]
  
      const MyCreditItems = MyCredit.map((MyCredit) =>
      <tr>
        <td>{MyCredit.Date}</td>
        <td>{MyCredit.Amount}</td>
        <br/><br/>
      </tr>
      );



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
                {MyCreditItems}
              </table>
                
                













            </div>
        );
    }}