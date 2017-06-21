import React, {Component} from 'react'
import client from '../api/client';
import StandingsComponent from '../components/StandingsComponent'


export default class StandingsContainer extends Component {
  constructor(props) {
      super(props);
      console.log(props);
      this.state = {standings: [], seasonId: props.match.params.seasonId};
   }

  fetchData(seasonId) {
     client({method: 'GET', path: 'http://localhost:8080/data/standings/' + this.state.seasonId}).then(response => {
           this.setState({standings: response.entity});
         });
   }

  componentDidMount() {
      this.fetchData();
    }

  render() {
    var standings = this.state.standings.map(standing =>
        <StandingsComponent standings={standing} />
    );
    return (
      <div>{standings}</div>
    )
  }

}
