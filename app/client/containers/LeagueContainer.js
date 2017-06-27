import React, {Component} from 'react';
import client from '../api/client';

import css from '../styles/root.css';
import responsive from '../styles/responsive.css';
import LeagueComponent from '../components/LeaguesComponent';
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'
export default class LeagueContainer extends Component {

    constructor(props) {
		super(props);
        var date = props.match.params.date ? props.match.params.date : new Date().toISOString().slice(0,10);
		this.state = {leagues: [], date: date};
     }
     fetchData(date) {
       client({method: 'GET', path: 'http://localhost:8080/data/fixtures/'+date}).then(response => {
             this.setState({leagues: response.entity});
           });

           if(date === new Date().toISOString().slice(0,10)) {
             this.connect();
           }
     }

    connect() {
       var sock = new SockJS('http://localhost:8080/gs-guide-websocket');
       var client = Stomp.over(sock);
       client.connect({}, function(frame) {
         console.log('Connected: ' + frame);
          client.subscribe("/topic/greetings", function(msg) {
            var data = JSON.parse(msg.body);
            this.setState({leagues:data});
          }.bind(this))
       }.bind(this));
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
