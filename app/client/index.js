/*
    ./client/index.js
*/
import React from 'react'
import ReactDOM from 'react-dom'
import DatePicker from './containers/DatePicker'
import LeagueContainer from './containers/LeagueContainer'
import TeamContainer from './containers/TeamContainer'
import {BrowserRouter, Route, Link} from 'react-router-dom'
import TopMatchContainer from './containers/TopMatchContainer'
import css from './styles/root.css';
import responsive from './styles/responsive.css';

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
                  <Route exactpath="/" component={DatePicker} />
                  <Route path="/fixtures/:date" component={LeagueContainer} />
                  <Route path="/team/:id" component={TeamContainer} />
                </div>
              </div>
              <div className="col-md-4 col-2">
                <TopMatchContainer />
              </div>
            </div>
          </div>
        </div>
      </div>
    </BrowserRouter>
), document.getElementById('root'));
