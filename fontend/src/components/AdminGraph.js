
import React, {Component} from 'react';
import { Chart } from "react-google-charts";

// https://react-google-charts.com/line-chart#material-design-linechart

export default class AdminGraph extends Component 
{

  constructor() {
    super();
    this.state = {
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
var details = await fetch(`/getAllBusDetails`)
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
  return (
    <div style={{display: 'inline-block'}}>
    <Chart style={{width:'800px'}}
    width={'500px'}
    height={'300px'}
    chartType="Bar"
    loader={<div>Loading Chart</div>}
    data={[
        ['Route', 'Seats', 'Passengers'],
        [ this.state.JourneyHis0[1], this.state.JourneyHis0[2], this.state.JourneyHis0[3]],
        [ this.state.JourneyHis1[1], this.state.JourneyHis1[2], this.state.JourneyHis1[3]],
    ]}
    options={{
        // Material design options
        chart: {
        title: 'Passenger Count by Route',
        },
    }}
    // For tests
    rootProps={{ 'data-testid': '2' }}
    />
</div>
  );
}}