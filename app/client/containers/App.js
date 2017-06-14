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
class Season extends React.Component {
    constructor(props) {
        super(props);
        this.state = {fixtures: '', url: props.url};
    }


    componentDidMount() {
        client({method: 'GET', path: this.state.url}).then(response => {
        			this.setState({fixtures: response.entity._links.fixtures});
        		});
    }
    render() {
        return(
            <FixtureList key={this.state.fixtures} url={this.state.fixtures} />
        )
    }
}

class FixtureList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {fixtures: [], url: props.url.href};
        console.log(props);
    }


    componentDidMount() {
        client({method: 'GET', path: this.state.url}).then(response => {
                    this.setState({fixtures: response.entity._embedded.fixtures});
                });
    }
    render() {
        var fixtures = this.state.fixtures.map(fixture =>
             <Fixture key={fixture._links.self.href} fixture={this.state.fixture}/>
        );

        return (
            <div>
            {fixtures} - hej
            </div>
        )
    }
}

class LeagueList extends React.Component {
    render() {
        var seasons = this.props.leagues.map(league =>
            <Season key={league._links.season.href} url={league._links.season.href} />
        );
        var leagues = this.props.leagues.map(league =>
            <League key={league._links.self.href} league={league} />
        );

        return(
            <div>
                    {leagues}
                    {seasons}
            </div>
        )
    }
}

class League extends React.Component {
    render() {
        return (
            <div>
                {this.props.league.name}
            </div>
        )
    }
}


class Fixture extends React.Component {
        render() {
            return <div>{this.props.localTeam_id}</div>
        }
}
