import React, { Component } from 'react';
import FixturesComponent from './FixturesComponent';

export default class LeagueComponent extends Component {
    render() {
      var fixtures = <FixturesComponent key={this.props.league.id} fixtures={this.props.league.fixtures} />
        return (
          <article id="live">
          <div className="panel">
            <div className="panel-heading">
            <a href="#">{this.props.league.name}</a>
            <i className="fa fa-star-o addToFav"></i>
            </div>
            <div className="panel-body">
                {fixtures}
            </div>
          </div>
          </article>
        )
    }
}
