import React, {Component} from 'react';
import client from '../api/client';
import TeamComponent from '../components/TeamComponent';

export default class TeamContainer extends Component {

  constructor(props) {
      super(props);
      console.log(props);
      this.state = {team: {} , id: props.match.params.id};
   }

  fetchData(id) {
     client({method: 'GET', path: 'http://localhost:8080/data/team/'+id}).then(response => {
           this.setState({team: response.entity});
         });
   }

  componentDidMount() {
      console.log('mounted');
      this.fetchData(this.state.id);
    }

  componentWillReceiveProps(nextProps) {
      console.log('mounted');
    this.fetchData(nextProps.match.params.id)
  }

    render() {
      return (
        <TeamComponent team={this.state.team} />
      )
    }
}
