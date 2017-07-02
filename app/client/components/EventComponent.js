import React, {Component} from 'react'

export default class EventComponent extends Component {
  render() {
    console.log(this.props);
    return (
      <div>
      <p>{this.props.event.type}</p>
      <p>{this.props.event.minute}</p>
      <p>{this.props.event.player_name}</p>
      <p>{this.props.event.related_player_name}</p>
      </div>
    )
  }
}
