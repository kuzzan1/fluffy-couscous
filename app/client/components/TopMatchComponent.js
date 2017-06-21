import React, { Component } from 'react';
import css from '../styles/root.css';
import responsive from '../styles/responsive.css';

export default class TopMatchComponent extends Component {
    render() {
        return(
          <div className="swiper-slide">
            <div className="img-holder left">
              <img src={this.props.fixture.localTeam.logo_path} />
            </div>
            <div className="scores text-center">
              {this.props.fixture.scores.localTeam_score} - {this.props.fixture.scores.visitorTeam_score}
            </div>
            <div className="img-holder right">
              <img src={this.props.fixture.visitorTeam.logo_path} />
            </div>
          </div>
        )
    }
}
