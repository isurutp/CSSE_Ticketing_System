import React, {Component} from 'react';

import "bootstrap/dist/css/bootstrap.min.css";

export default class TransferCredit extends Component {

    constructor() {
        super();
        this.state = {
          cardNumber: '4422 2156 0567 9000',
          amount: 100
        };

        this.handleChange = this.handleChange.bind(this);
        this.TransferMoney = this.TransferMoney.bind(this);
    }
    
    handleChange({ target }) {
        this.setState({
          [target.name]: target.value
        });
      }

    TransferMoney() 
    {
        if(this.state.amount<100)
        {
            // alert('Please enter a valid amount')
            return;
        }

        if (window.confirm('Are you sure you wish to Transfer '+this.state.amount+' from your bank account')) 
        {
            alert('Transaction is processing')
        }
        else
        {
            this.setState({amount: 100});
        }
    }
    

    render() {
        return(
            <form>
                <div>
                    <h4 className="title">Transfer Credit from Card</h4>
                </div>
                <br/>
                <div style={{textAlign:'center'}}>
                    <table style={{margin: '0 auto'}}>
                        <tr>
                            <td><p>Card Number: </p></td>
                            <td><input type="text" placeholder={this.state.cardNumber} readOnly/></td> 
                        </tr>                        
                        <tr>
                            <td><p>amount: </p></td>
                            <td><input type="number" name="amount" min="100" value={ this.state.amount } onChange={ this.handleChange } title="Minimum value that can be transfered is 100"/></td> 
                        </tr>
                    </table>

                    <br/>
                    {/* Button */}
                    <div className="mbr-section-btn">
                        <button className="btn btn-md btn-primary display-4" onClick={this.TransferMoney} >Transfer</button>
                    </div>
                </div>
            </form>
        );
    }}