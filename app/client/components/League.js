const React = require('react');

export default class League extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.league.name}</td>
			</tr>
		)
	}
}
