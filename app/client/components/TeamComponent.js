import React, { Component } from 'react';
import PlayerContainer from '../containers/PlayerContainer'
import CoachComponent from './CoachComponent'

export default class TeamComponent extends Component {
        render() {
            var players = [];
            if(this.props.team.squad && this.props.team.squad.data) {
                players = this.props.team.squad.data.map( player =>
                    <PlayerContainer key={player.player_id} player={player} />
                )
            }

            var coach;
            if(this.props.team.coach) {
              coach = <CoachComponent key={this.props.team.coach.coach_id} coach={this.props.team.coach} />
              console.log(coach)
            }

            return (
              <div>
                  <img src={this.props.team.logo_path} />
                  {this.props.team.name}
                  {coach}
                  {players}
              </div>
            )
        }
}
