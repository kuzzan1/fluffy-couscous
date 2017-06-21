import React, { Component } from 'react';
import FixtureComponent from './FixtureComponent';
export default class FixturesComponent extends Component {
    render() {
        var fixtures = this.props.fixtures.map(fixture =>
             <FixtureComponent key={fixture.id} fixture={fixture}/>
        );

        return (
            <table className="table table-striped table-hover">
              <tbody className="text-center">
                {fixtures}
              </tbody>
            </table>
        )
    }
}
