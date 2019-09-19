import React, {Component} from 'react';
import Cookies from 'universal-cookie';

export default class BlueGradientBar extends Component {
  constructor() {
    super();
    const userDetails = new Cookies();
    this.state = {
      name: userDetails.get('username'),
      balance: userDetails.get('creditBalance')
    };
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