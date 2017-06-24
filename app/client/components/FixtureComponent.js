import {Link} from 'react-router-dom'
import React, { Component } from 'react';

export default class Fixture extends Component {
        render() {
            return (
              <tr>
                <td>{this.props.fixture.time}</td>
                <td><img src={this.props.fixture.localTeam.logo} /></td>
                <td className="text-green"><li className="fa fa-circle live">{this.props.fixture.currentMinute}</li></td>
                <td className="text-right"><Link to={"/team/"+this.props.fixture.localTeam.id} id={this.props.fixture.localTeam.id}>{this.props.fixture.localTeam.name}</Link></td>
                <td className="score text-green">{this.props.fixture.scores.localTeam_Score} - {this.props.fixture.scores.visitorTeam_score}</td>
                <td className="text-left">
                <Link to={"/team/"+this.props.fixture.visitorTeam.id} id={this.props.fixture.visitorTeam.id}>
                {this.props.fixture.visitorTeam.name}</Link></td>
                <td><img src={this.props.fixture.visitorTeam.logo} /></td>
              </tr>
            )
        }
}
