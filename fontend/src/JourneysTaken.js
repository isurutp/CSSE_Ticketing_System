import React, {Component} from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import Cookies from 'universal-cookie';

import BlueGradientbar from "./components/BlueGradientBar";
import Navbar from "./components/NavBar";

export default class JourneysTaken extends Component {
  constructor() {
    super();
    const userDetails = new Cookies();
    this.state = {
      name: userDetails.get('username'),
      JourneyHis0: ["","","",""],
      JourneyHis1: ["","","",""],
      JourneyHis2: ["","","",""],
      JourneyHis3: ["","","",""],
      JourneyHis4: ["","","",""],
      JourneyHis5: ["","","",""],
      JourneyHis6: ["","","",""],
      JourneyHis7: ["","","",""],
      JourneyHis8: ["","","",""],
      JourneyHis9: ["","","",""],
    };

    this.getDetails = this.getDetails.bind(this);
    this.getDetails();
    
}

  async getDetails()
  {  
    //Getting user's journey history from backend
    var details = await fetch(`/searchJourneysTaken?username=${this.state.name}&rows=10`)
    .then(function(response){ return response.text(); })
  
    if(!details.includes("error"))
    {
      var myArray = details.split('],[');
      var result = ["","","","","","","","","",""]
      for(var i=0;i<10;i++)
      {
        myArray[i] = myArray[i].replace(/\[/g,'')
        myArray[i] = myArray[i].replace(/\]/g,'')
        myArray[i] = myArray[i].replace(/\"/g,'')
        result[i] = myArray[i].split(',')
      }
  
    this.setState({JourneyHis0: result[0]});
    this.setState({JourneyHis1: result[1]});
    this.setState({JourneyHis2: result[2]});
    this.setState({JourneyHis3: result[3]});
    this.setState({JourneyHis4: result[4]});
    this.setState({JourneyHis5: result[5]});
    this.setState({JourneyHis6: result[6]});
    this.setState({JourneyHis7: result[7]});
    this.setState({JourneyHis8: result[8]});
    this.setState({JourneyHis9: result[9]});
    }
  }




    render() {

        const Trips= [
            {Date: this.state.JourneyHis0[0], From: this.state.JourneyHis0[1], To: this.state.JourneyHis0[2], price: this.state.JourneyHis0[3]},
            {Date: this.state.JourneyHis1[0], From: this.state.JourneyHis1[1], To: this.state.JourneyHis1[2], price: this.state.JourneyHis1[3]},
            {Date: this.state.JourneyHis2[0], From: this.state.JourneyHis2[1], To: this.state.JourneyHis2[2], price: this.state.JourneyHis2[3]},
            {Date: this.state.JourneyHis3[0], From: this.state.JourneyHis3[1], To: this.state.JourneyHis3[2], price: this.state.JourneyHis3[3]},
            {Date: this.state.JourneyHis4[0], From: this.state.JourneyHis4[1], To: this.state.JourneyHis4[2], price: this.state.JourneyHis4[3]},
            {Date: this.state.JourneyHis5[0], From: this.state.JourneyHis5[1], To: this.state.JourneyHis5[2], price: this.state.JourneyHis5[3]},
            {Date: this.state.JourneyHis6[0], From: this.state.JourneyHis6[1], To: this.state.JourneyHis6[2], price: this.state.JourneyHis6[3]},
            {Date: this.state.JourneyHis7[0], From: this.state.JourneyHis7[1], To: this.state.JourneyHis7[2], price: this.state.JourneyHis7[3]},
            {Date: this.state.JourneyHis8[0], From: this.state.JourneyHis8[1], To: this.state.JourneyHis8[2], price: this.state.JourneyHis8[3]},
            {Date: this.state.JourneyHis9[0], From: this.state.JourneyHis9[1], To: this.state.JourneyHis9[2], price: this.state.JourneyHis9[3]},
          ]
    
        const TripItems = Trips.map((Trips) =>
        <tr>
          <td>{Trips.Date}</td>
          <td>{Trips.From}</td>
          <td>{Trips.To}</td>
          <td>{Trips.price}</td>
        </tr>
        );



        return(
            <div>
                <Navbar/>
                <section className="header1 cid-rB4qRp8JKI" id="header16-2" style={{height:'350px'}}>
                    <BlueGradientbar/>
                    <br/><br/>                       
                    <h4 style={{textAlign: 'center'}} >Journeys Taken</h4>
                </section>

            <p>*Only last 10 journeys are shown</p>
            <br/><br/>
            
            <table style={{textAlign:'center', width: '80%',margin: '0 auto'}}>
                <tr style={{color:'blue'}}>
                  <th>Date</th>
                  <th>From</th>
                  <th>To</th>
                  <th>Price</th>
                </tr>
                <br/>
                {TripItems}
              </table>
            

            </div>
        );
    }
}
