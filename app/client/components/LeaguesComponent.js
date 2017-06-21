
import React, { Component } from 'react';
import LeagueComponent from './LeagueComponent';

export default class LeaguesComponent extends Component {
    render() {
        var leagues = this.props.leagues.map(league =>
            <LeagueComponent key={league.id} league={league} />
        );
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
