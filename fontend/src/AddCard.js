import React, {Component} from 'react';
import Cookies from 'universal-cookie';
import "bootstrap/dist/css/bootstrap.min.css";

export default class AddCard extends Component {

    constructor() {
        super();
        const userDetails = new Cookies();
        this.state = {
            name: userDetails.get('username'),
            cardNo: null,
            month: 'january',
            year: 2020,
            cvv: null
        };
    
        this.handleChange = this.handleChange.bind(this);
        this.addCard = this.addCard.bind(this);
    }
    
    addCard(event)
    { 
        if(this.state.cardNo != null && this.state.cvv != null)
        {
            // Sending form data to backend
            event.preventDefault();
            var details = [this.state.name, this.state.cardNo, this.state.month, this.state.year, this.state.cvv];
            fetch(`/addCreditCard?cardDetails=${details}`);

            alert('Card has been added to your Account');
            window.location.reload();  
        }
        else
        {
            alert('Please fill all fields');
        }
    }

    handleChange({ target }) {
        this.setState({
          [target.name]: target.value
        });
      }

    render() {
        return(
            <form>
                <div>
                <h4 className="title">Add a Card</h4>
                </div>
                <div>
                {/* Card Number */}
                <input onChange={ this.handleChange } name="cardNo" type="text" placeholder="Card Number" />
                {/* Date Field */}
                <div>
                    <div className="month">
                    <select name="month" onChange={ this.handleChange }>
                        <option value="january">January</option>
                        <option value="february">February</option>
                        <option value="march">March</option>
                        <option value="april">April</option>
                        <option value="may">May</option>
                        <option value="june">June</option>
                        <option value="july">July</option>
                        <option value="august">August</option>
                        <option value="september">September</option>
                        <option value="october">October</option>
                        <option value="november">November</option>
                        <option value="december">December</option>
                    </select>
                    </div>
                    <div>
                    <select name="year" onChange={ this.handleChange }>
                        <option value={2020}>2020</option>
                        <option value={2021}>2021</option>
                        <option value={2022}>2022</option>
                        <option value={2023}>2023</option>
                        <option value={2024}>2024</option>
                        <option value={2025}>2025</option>
                        <option value={2026}>2026</option>
                        <option value={2027}>2027</option>
                        <option value={2028}>2028</option>
                    </select>
                    </div>
                </div>
                {/* Card Verification Field */}
                <div>
                    <div>
                        <input onChange={ this.handleChange } name="cvv" type="text" placeholder="CVV" />
                    </div>
                    <div>
                        <p>3 or 4 digits usually found <br /> on the signature strip</p>
                    </div>
                </div>
                {/* Buttons */}
                <div className="mbr-section-btn"><button className="btn btn-md btn-primary display-4" onClick={this.addCard} >Add Card</button></div>
                </div>
            </form>
        );
    }}