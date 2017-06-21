import React, { Component } from 'react';

export default class TeamComponent extends Component {
        render() {
            return (
              <div>
              <img src={this.props.team.logo_path} />
                {this.props.team.name}
              </div>
            )
        }
}
