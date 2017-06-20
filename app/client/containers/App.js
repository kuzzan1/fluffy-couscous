import React from 'react';
import client from '../api/client';

import css from '../styles/root.css';
import responsive from '../styles/responsive.css';

export default class App extends React.Component {

    constructor(props) {
    		super(props);
    		this.state = {leagues: []};
     }

    componentDidMount() {
        client({method: 'GET', path: 'http://localhost:8080/api/leagues'}).then(response => {
        			this.setState({leagues: response.entity._embedded.leagues});
        		});
    	}

  render() {
      return (
        <LeagueList leagues={this.state.leagues}/>          
      )
    }
}


class LeagueList extends React.Component {
    render() {
        var leagues = this.props.leagues.map(league =>
            <League key={league._links.self.href} league={league} />
        );
        return(
          <div id="allmatches" className="tab-pane fade active in">
            {leagues}
          </div>
        )
    }
}

class League extends React.Component {
    render() {
      var fixtures = <FixtureList key={this.props.league._links.fixtures} url={this.props.league._links.fixtures} />
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


class FixtureList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {fixtures: [], url: props.url.href};
    }


    componentDidMount() {
        client({method: 'GET', path: this.state.url + "?projection=with_meta"}).then(response => {
                    this.setState({fixtures: response.entity._embedded.fixtures});
                });
    }
    render() {
        var fixtures = this.state.fixtures.map(fixture =>
             <Fixture key={fixture._links.self.href} fixture={fixture}/>
        );

        return (
            <table className="table table-striped table-hover">
              <tbody className="text-center">
                {fixtures}
              </tbody>
            </table>
        )
    }
}

class Fixture extends React.Component {
        render() {
            return (
              <tr>
                <td>{this.props.fixture.time}</td>
                <td className="text-green"><li className="fa fa-circle live">40'</li></td>
                <td className="text-right"><a href="#">{this.props.fixture.localTeam.name}</a></td>
                <td className="score text-green">{this.props.fixture.scores.ft_score}</td>
                <td className="text-left"><a href="#">{this.props.fixture.visitorTeam.name}</a></td>
              </tr>
            )
        }
}
