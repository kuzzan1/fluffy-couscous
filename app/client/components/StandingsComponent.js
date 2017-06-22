import React, {Component} from 'react'
import {Link} from 'react-router-dom'

export default class StandingsComponent extends Component {


  render() {
    return (
      <tr>
          <td>{this.props.standings.position}</td>
          <td><Link to={"/team/"+this.props.standings.team_id} key={this.props.standings.team_id}> {this.props.standings.team_name}</Link></td>
          <td>{this.props.standings.status}</td>
      </tr>
    )
  }
}
