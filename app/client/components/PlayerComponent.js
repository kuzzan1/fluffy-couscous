import React, { Component } from 'react';


export default class PlayerComponent extends Component {


    render() {
        return (
            <div>
            <div>{this.props.player.fullname}</div>
            <div>{this.props.player.nationality}</div>
            <div><img src={this.props.player.image_path} /></div>
            <div>Goals - {this.props.stats.goals}</div>
            <div>Assists - {this.props.stats.assists}</div>
            <div>Appearences - {this.props.stats.appearences}</div>
            <div>Number - {this.props.stats.number}</div>
            </div>
        )
    }
}
