import * as React from "react";
import { Chart } from "react-google-charts";

// https://react-google-charts.com/line-chart#material-design-linechart

export default props => {
  return (
    <div style={{display: 'inline-block'}}>
    <Chart style={{width:'800px'}}
    width={'500px'}
    height={'300px'}
    chartType="Bar"
    loader={<div>Loading Chart</div>}
    data={[
        ['Route', 'Sales', 'Expenses', 'Profit'],
        ['Malabe-Kaduwela', 1000, 400, 200],
        ['Galle-Jaffna', 1170, 460, 250],
        ['Kandy-Panadura', 660, 1120, 300],
        ['Galle-Jaffna', 1030, 540, 350],
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
}