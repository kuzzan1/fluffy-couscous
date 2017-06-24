import React, {Component} from 'react'

export default class TeamComponent extends Component {
  render() {
    return (
      <div>
        {this.props.coach.fullName}
      </div>
    )
  }
}
