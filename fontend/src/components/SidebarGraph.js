import * as React from "react";
import { Chart } from "react-google-charts";

// https://react-google-charts.com/line-chart#material-design-linechart

export default props => {
  return (
    <div style={{display: 'inline-block'}}>
      <Chart
        width={'300px'}
        height={'200px'}
        chartType="LineChart"
        loader={<div>Loading Chart</div>}
        data={[
          ['x', 'y'],
          [0, 0],
          [1, 10],
          [2, 23],
          [3, 17],
          [4, 18],
          [5, 9],
          [6, 11],
          [7, 27],
          [8, 33],
          [9, 40],
          [10, 32],
          [11, 35],
        ]}
        options={{
          hAxis: {
            title: 'Fare',
          },
          vAxis: {
            title: 'Date',
          },
        }}
        rootProps={{ 'data-testid': '1' }}
      />
</div>
  );
}