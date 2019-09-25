import React, {Component} from 'react';
import Cookies from 'universal-cookie';

export default class CreditCardDetails extends Component {
  constructor() {
    super();
    const userDetails = new Cookies();
    this.state = {
      name: userDetails.get('username'),
      CardNumber: 'No cards added'
    };

    this.getCardNumber = this.getCardNumber.bind(this);

    this.getCardNumber();
}

async getCardNumber()
{
    //Getting data from backend
    var number = await fetch(`/getCardNumber?username=${this.state.name}`)
                    .then(function(response){ return response.text(); })

    if(!!number)        // !! means check for undefined, null, and empty value
    {
        this.setState({CardNumber: number});
    }
}

  render() {
    return (
      <div>
            {/* Credit card images and details */}
            <section className="counters2 counters cid-rB4rT8mBKN" id="counters2-3">
              <div className="container pt-4 mt-2">
              <h3 className="mbr-section-subtitle pb-5 align-left mbr-fonts-style display-5">Your Credit cards</h3>
                <div className="media-container-row">
                  <div className="media-block" style={{width: '22%'}}>
                    <div className="mbr-figure">
                      <img src="assets/images/mbr-1024x647.jpg" alt="" title />
                    </div>
                  </div>
                  <div className="cards-block">
                      <div className="card px-3 align-left col-12 col-md-6">
                            <h3 className="count py-3 mbr-fonts-style display-7">Credit Card<br /><br />{this.state.CardNumber}</h3>
                      </div>
                  </div>
                </div>
              </div>
            </section>
      </div>
    );
  }
};