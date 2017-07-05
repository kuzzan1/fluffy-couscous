import React, { Component } from 'react';
import client from '../api/client';
import PlayerComponent from '../components/PlayerComponent'

export default class PlayerContainer extends Component {
    constructor(props) {
        super(props);
        this.state = {player: {}, stats: this.props.player};
     }

    fetchData() {
       client({method: 'GET', path: window.location.protocol+'//'+window.location.hostname+':8080/data/player/' + this.props.player.player_id}).then(response => {
             this.setState({player: response.entity});
           });
     }

    componentDidMount() {
        this.fetchData();
      }

    render() {
      return(
          <PlayerComponent key={this.state.player.id} player={this.state.player} stats={this.state.stats} />
      )
  }
}
