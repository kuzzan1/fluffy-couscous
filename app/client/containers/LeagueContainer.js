import React, {Component} from 'react';
import client from '../api/client';

import css from '../styles/root.css';
import responsive from '../styles/responsive.css';
import LeagueComponent from '../components/LeaguesComponent';

export default class LeagueContainer extends Component {

    constructor(props) {
    		super(props);
    		this.state = {leagues: [], date: props.match.params.date};
     }
     fetchData(date) {
       client({method: 'GET', path: 'http://localhost:8080/data/fixtures/'+date}).then(response => {
             this.setState({leagues: response.entity});
           });
     }
    componentDidMount() {
        this.fetchData(this.state.date);
    	}

      componentWillReceiveProps(nextProps) {
        this.fetchData(nextProps.match.params.date)
      }

  render() {
      return (
        <LeagueComponent leagues={this.state.leagues}/>
      )
    }
}
