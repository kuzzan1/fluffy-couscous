import React from 'react';
import client from '../api/client';

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
      return <LeagueList leagues={this.state.leagues}/>;
    }
}

class LeagueList extends React.Component {
    render() {
        var leagues = this.props.leagues.map(league =>
            <League key={league._links.self.href} league={league} />
        );
        return(
            <div>
                    {leagues}
            </div>
        )
    }
}

class League extends React.Component {
    render() {
      var fixtures = <FixtureList key={this.props.league._links.fixtures} url={this.props.league._links.fixtures} />
        return (
            <div>
                <h1>{this.props.league.name}</h1>
                {fixtures}
            </div>
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
            <div>
            {fixtures}
            </div>
        )
    }
}

class Fixture extends React.Component {
        render() {
            return (
              <div style={{display:'flex'}}>
                <div style={{height:'40px'}}>
                {this.props.fixture.time}  

                <img style={{maxHeight:'100%'}} src={this.props.fixture.localTeam.logo} />
                {this.props.fixture.localTeam.name}
                  <span style={{padding: '5px'}}>{this.props.fixture.scores.ft_score}</span>
                   {this.props.fixture.visitorTeam.name} <img style={{maxHeight:'100%'}} src={this.props.fixture.visitorTeam.logo} />
                </div>
              </div>
            )
        }
}
