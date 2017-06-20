import css from '../styles/root.css';
import responsive from '../styles/responsive.css';
import React from 'react';
import DateComponent from '../components/DateComponent.js';


export default class DatePicker extends React.Component {

  constructor(props) {
      super(props);
      var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
      var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
      this.state = {days: days, months: months};
   }

  render() {
    var dates = []
    var date = new Date();
     for(var i = 0; i < 7; i++) {
        date.setDate(date.getDate() + (i === 0 ? 0 : 1))
        var dayNumber = date.getDate();
        var dayName = this.state.days[date.getDay()]
        var monthName =  this.state.months[date.getMonth()]
        dates.push(<DateComponent key={i} month='Jun' dayName={dayName} dayNumber={dayNumber} date={date.toISOString().substring(0, 10)}/>)
      }
      return (
        <ul className="swiper-wrapper">
            {dates}
        </ul>
      )
    }
}
