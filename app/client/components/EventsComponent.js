import React, {Component} from 'react'
import EventComponent from './EventComponent'

export default class EventsComponent extends Component {
  render() {
    var events = this.props.events.map(event =>
         <EventComponent key={event.id} event={event} />
    );
    return (
      <p>{events}</p>
    )
  }
}
