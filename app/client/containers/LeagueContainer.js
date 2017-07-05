import React, {Component} from 'react';
import client from '../api/client';

import LeagueComponent from '../components/LeaguesComponent';
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'

export default class LeagueContainer extends Component {

  constructor(props) {
	  super(props);
    var date = props.match.params.date ? props.match.params.date : new Date().toISOString().slice(0,10);
    this.state = {leagues: [], date: date, subscription: null};
   }
   fetchData(date) {
     client({method: 'GET', path: window.location.protocol+'//'+window.location.hostname+':8080/data/fixtures/'+date}).then(response => {
           this.setState({leagues: response.entity});
         });
         if(!this.state.subscription) {
           var sock = new SockJS(window.location.protocol+'//'+window.location.hostname+':8080/gs-guide-websocket');
           var stomp = Stomp.over(sock);
         }
         if(date === new Date().toISOString().slice(0,10)) {
           this.connect(stomp);
         } else if(this.state.subscription) {
           this.state.subscription.unsubscribe();
           this.setState({'subscription': null});
         }


   }
  connect(client) {
     client.connect({}, function(frame) {
       console.log('Connected: ' + frame);
        var subscription = client.subscribe("/topic/greetings", function(msg) {
          var data = JSON.parse(msg.body);
          this.setState({leagues:data});
        }.bind(this));
        this.setState({'subscription': subscription});
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
