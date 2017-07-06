/*
    ./client/index.js
*/
import React from 'react'
import ReactDOM from 'react-dom'
import {BrowserRouter, Route, Link, Switch} from 'react-router-dom'

import DatePicker from './containers/DatePicker'
import LeagueContainer from './containers/LeagueContainer'
import TeamContainer from './containers/TeamContainer'
import TopMatchContainer from './containers/TopMatchContainer'
import StandingsContainer from './containers/StandingsContainer'
import FooterComponent from './components/FooterComponent'
import InfoComponent from './components/InfoComponent'
import styles from './styles/main.less'
import root from './styles/root.less'
ReactDOM.render((
  <BrowserRouter>
    <div id="wrapper">
    <div className="cover-strip"></div>
      <div className="top-nav">
          <div className="container">
             <div className="nav-brand">
                <a href="#">live<span>score12.com</span></a>
             </div>
          </div>
       </div>
       <div className="container parent-container" id="panel-top">
         <div className="parent-panel">
            <div className="row">
              <div className="col-md-8 col-1">
                <div id="tabContent" className="tab-content">
                  <DatePicker />
                  <Switch>
                    <Route path="/fixtures/:date" component={LeagueContainer} />
                    <Route path="/team/:id" component={TeamContainer} />
                    <Route path="/standings/:seasonId" component={StandingsContainer} />
                    <Route path="/" component={LeagueContainer} />
                  </Switch>
                </div>
              </div>
              <div className="col-md-4 col-2">
                <TopMatchContainer />
              </div>
            </div>
          </div>
        </div>
        <FooterComponent />
        <InfoComponent />
      </div>
    </BrowserRouter>
), document.getElementById('root'));
