import React, {Component} from 'react';
import Cookies from 'universal-cookie';

export default class OtherOperations extends Component {

  CreditHistory()
  {
          const cookies = new Cookies();
          cookies.get('page');
          cookies.set('page', 'creditHistory');
          window.location.reload();  
  }

  JourneyHistory()
  {
          const cookies = new Cookies();
          cookies.get('page');
          cookies.set('page', 'journeyHistory');
          window.location.reload();  
  }

  render() {
    return (
      <div>
            <section className="counters2 counters cid-rB4rT8mBKN" id="counters2-3">
              <div className="container pt-4 mt-2">
              <h3>Other Operations:</h3><br/>
              <ul style={{marginLeft:40, listStyleType: 'none'}}>
                  <li><a onClick={this.JourneyHistory}>Look up Journeys Taken</a><br/><br/></li>
                  <li><a onClick={this.CreditHistory}>Look up Fares Paid</a><br/><br/></li>
              </ul>
              </div>
            </section>
      </div>
    );
  }
};