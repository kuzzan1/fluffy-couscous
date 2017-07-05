import React from 'react';
import DateComponent from '../components/DateComponent.js';
import swiper from '../styles/swiper.less'

export default class DatePicker extends React.Component {

  constructor(props) {
      super(props);
      var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
      var days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
      this.state = {days: days, months: months};
  }
  componentDidMount() {
    var datesSwiper = new Swiper('.dates', {
  		direction: 'horizontal',
  		slidesPerView: 7,
  		spaceBetween: 5,
  		breakpoints: {
  			680: {
  				slidesPerView: 6
  			},
  			560: {
  				slidesPerView: 5
  			},
  			420: {
  				slidesPerView: 4
  			}
  		}
  	});
  }
  render() {
    var dates = []
    var date = new Date();
     for(var i = 0; i < 7; i++) {
        date.setDate(date.getDate() + (i === 0 ? 0 : 1))
        var dayNumber = date.getDate();
        var dayName = this.state.days[date.getDay()]
        var monthName =  this.state.months[date.getMonth()]
        dates.push(
          <DateComponent
                        key={i}
                        month={monthName}
                        dayName={dayName}
                        dayNumber={dayNumber}
                        date={date.toISOString().substring(0, 10)}
          />)
      }
      return (
        <div className="dates swiper-container-horizontal">
            <ul className="swiper-wrapper">
              {dates}
            </ul>
        </div>
      )
    }
}
