import {Link} from 'react-router-dom';
import React, {Component} from 'react';

export default class DateComponent extends Component {
    render() {
      return (
        <Link to={"/fixtures/"+this.props.date} key={this.props.date}>
          <li className="swiper-slide">
            <span>{this.props.dayNumber}</span> {this.props.month}
            <span className="sm">{this.props.dayName}</span>
          </li>
        </Link>
      )
    }
}
