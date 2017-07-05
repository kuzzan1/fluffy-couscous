import {Link} from 'react-router-dom'
import React, { Component } from 'react'
import EventsComponent from './EventsComponent'

export default class Fixture extends Component {

  constructor(props) {
    super(props);
    this.state = {openEvents: false};
  }
  toggleEvents() {
    this.setState({
      openEvents: !this.state.openEvents
    });
  }
  render() {
    var events = this.state.openEvents ? <EventsComponent open={this.state.openEvents} events={this.props.fixture.events} /> : null;
      return (
        <tr onClick={this.toggleEvents.bind(this)}>
          <td>{this.props.fixture.time}</td>
          <td className="text-green"><i className="fa fa-circle live">{this.props.fixture.currentMinute}</i></td>
          <td className="text-right"><Link to={"/team/"+this.props.fixture.localTeam.id} id={this.props.fixture.localTeam.id}>{this.props.fixture.localTeam.name}</Link></td>
          <td className="score text-green">{this.props.fixture.scores.localTeam_Score} - {this.props.fixture.scores.visitorTeam_score}</td>
          <td className="text-left">
          <Link to={"/team/"+this.props.fixture.visitorTeam.id} id={this.props.fixture.visitorTeam.id}>
          {this.props.fixture.visitorTeam.name}</Link></td>
          <td>{events}</td>
        </tr>
      )
  }
}
