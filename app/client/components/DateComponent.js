import {Link} from 'react-router-dom';
import React, {Component} from 'react';
import css from '../styles/root.css';
import responsive from '../styles/responsive.css';

export default class DateComponent extends Component {
    render() {
        var scroller = {
            display: 'inline-block',
            color: 'white',
            textAlign: 'center',
            padding: '14px',
            textDecoration: 'none'
        }
        var activeScroller = {
            display: 'inline-block',
            color: 'red',
            textAlign: 'center',
            padding: '14px',
            textDecoration: 'none'
        }
      return (
        <Link to={"/fixtures/"+this.props.date} key={this.props.date} style={scroller}>
            <span>{this.props.dayNumber}</span> {this.props.month}
            <span className="sm"> {this.props.dayName}</span>
        </Link>
      )
    }
}
