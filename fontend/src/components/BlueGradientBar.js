import React, {Component} from 'react';
import Cookies from 'universal-cookie';

export default class BlueGradientBar extends Component {
  constructor() {
    super();
    const userDetails = new Cookies();
    this.state = {
      name: userDetails.get('username'),
      balance: 0.0
    };

    this.getBalance = this.getBalance.bind(this);

    this.getBalance();
}

    async getBalance()
    {
        //Getting data from backend
        var value = await fetch(`/getAmount?username=${this.state.name}`)
                        .then(function(response){ return response.text(); })

        if(!!value)        // !! means check for undefined, null, and empty value
        {
            this.setState({balance: value});
        }
    }

  render() {
    return (
      <div>
          {/* BLue Graident bar */}
          <style dangerouslySetInnerHTML={{__html: "\n\n#grad2 {\n  height: 100px;\n  background-color: blue; /* For browsers that do not support gradients */\n  background-image: linear-gradient(90deg, rgb(1,84,150), rgb(23,189,211)); /* Standard syntax (must be last) */\n}\n\n" }} />
            <div id="grad2" style={{color:'white'}}>
              <br/>
              <div style={{textAlign: 'left', float: 'left', marginLeft:20}}>
                <h3>Welcome back {this.state.name}</h3>
                <h6>{new Date().toDateString()}</h6>
              </div>
              <div style={{textAlign: 'right', float: 'right', marginRight:20}}>
                  <h3>Credit Card Balance:</h3>
                  <h4> {this.state.balance} </h4>
              </div>
              <br/>            
            </div>
      </div>
    );
  }
};