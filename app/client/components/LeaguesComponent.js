
import React, { Component } from 'react';
import LeagueComponent from './LeagueComponent';

export default class LeaguesComponent extends Component {
    constructor(props) {
      super(props);
      this.state = {filter: [], leagues: this.props.leagues};
    }

    componentWillReceiveProps(nextProps) {
      if(nextProps.filter) {
        this.setState({filter: nextProps.filter, leagues: nextProps.leagues});
      }
      this.setState({leagues: nextProps.leagues});
    }

    render() {
        var leagues = this.state.leagues.map(function(league) {
          if(this.state.filter.length === 0 || this.state.filter.contains(league.name)) {
            return <LeagueComponent key={league.id} league={league} />
          }
        }, this);
				if(leagues.length > 0) {
					return(
	          <div id="allmatches" className="tab-pane fade active in">
	            {leagues}
	          </div>
	        )
				} else {
					return (
						<div id="allmatches" className="tab-pane fade active in">
	            No matches for this date
	          </div>
					)
				}

    }
}
