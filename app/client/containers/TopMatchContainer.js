import React, {Component} from 'react'
import client from '../api/client';
import TopMatchComponent from '../components/TopMatchComponent'


export default class TopMatchContainer extends Component {
  constructor(props) {
      super(props);
      this.state = {fixtures: []};
   }

  fetchData() {
     client({method: 'GET', path: window.location.protocol+'//'+window.location.hostname+':8080/data/fixture/topMatch'}).then(response => {
           this.setState({fixtures: response.entity});
         });
   }

  componentDidMount() {
      this.fetchData();
    }


  render() {
    var fixtures = this.state.fixtures.map(fixture =>
         <TopMatchComponent key={fixture.id} fixture={fixture}/>
    );
    if(fixtures.length > 0) {
      return (
        <div className="panel match-results">
          <div className="panel-heading">
            <div className="panel-title">Today's Top Games</div>
          </div>
          <div className="date">21 <span>Jun</span></div>
          <div className="panel-body swiper-container-horizontal">
            <div className="swiper-wrapper">
                {fixtures}
            </div>
          </div>
        </div>
      )
    }   else {
      return <div></div>
    }
  }

}
