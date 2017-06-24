import React, { Component } from 'react';
import FixturesComponent from './FixturesComponent';
import {Link} from 'react-router-dom'
export default class LeagueComponent extends Component {
  render() {
      var fixtures = <FixturesComponent key={this.props.league.id} fixtures={this.props.league.fixtures} />
        return (
          <article id="live">
          <div className="panel">
            <div className="panel-heading">
            <Link to={"/standings/"+this.props.league.current_season_id} key={this.props.league.current_season_id}>{this.props.league.name}</Link>
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
