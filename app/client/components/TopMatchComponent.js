import React, { Component } from 'react';
import {Link} from 'react-router-dom';

export default class TopMatchComponent extends Component {
    render() {
        return(
          <div className="swiper-slide">
            <div className="img-holder pull-left">
              <img src={this.props.fixture.localTeam.logo_path} />
            </div>
            <div className="scores text-center">
            <Link to={"/"} key={this.props.fixture.id}>
                {this.props.fixture.scores.localteam_score} - {this.props.fixture.scores.visitorteam_score}
            </Link>
            </div>
            <div className="img-holder pull-right">
              <img src={this.props.fixture.visitorTeam.logo_path} />
            </div>
          </div>
        )
    }
}
