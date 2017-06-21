import React, {Component} from 'react'


export default class StandingsComponent extends Component {
  render() {
    return (
      <div>
          {this.props.position}
          {this.props.name}
      </div>
    )
  }
}
