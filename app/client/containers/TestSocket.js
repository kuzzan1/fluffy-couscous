import React, {Component} from 'react'
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'

export default class TestSocket extends Component {

  constructor(props) {
      super(props);
      this.state = {league: {}};
   }

   connect() {
      var sock = new SockJS('http://localhost:8080/gs-guide-websocket');
      var client = Stomp.over(sock);
      client.connect({}, function(frame) {
        console.log('Connected: ' + frame);
         client.subscribe("/topic/greetings", function(msg) {
          console.log("got data");
           var data = JSON.parse(msg.body);
           console.log(data);
           this.setState({league:data});
         })
      });
   }

  componentDidMount() {
     this.connect();
  }

    handleData(data) {
      const league = JSON.parse(data)
      console.log(league);
      this.setState({leauge: league})
    }

    render() {
      return (
        <div>hej</div>
      )
    }

}
