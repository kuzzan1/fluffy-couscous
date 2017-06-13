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
            <table>
                <tbody>
                    <tr>
                        <th>Name</th>
                    </tr>
                    {leagues}
                </tbody>
            </table>
        )
    }
}

class League extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.league.name}</td>
            </tr>
        )
    }
}
