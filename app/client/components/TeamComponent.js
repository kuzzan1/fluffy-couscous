import React, { Component } from 'react';
import PlayerContainer from '../containers/PlayerContainer'

export default class TeamComponent extends Component {
        render() {
            var players = [];
            if(this.props.team.squad && this.props.team.squad.data) {
                players = this.props.team.squad.data.map( player =>
                    <PlayerContainer key={player.player_id} player={player} />
                )
            }

            return (
              <div>
                  <img src={this.props.team.logo_path} />
                  {this.props.team.name}
                  {players}
              </div>
            )
        }
}
