import React, {Component} from "react";


class BurgerRow extends Component {
    render() {
        return (
            <div className="row">
                <span className="col-8 text-left"><b> ИМЕ:  </b>{this.props.burger.name}</span>
                <span className="col-6 text-left"><b>  СОСТОЈКИ: </b>{this.props.burger.description}</span>
            </div>
        )
    }
}

export default BurgerRow;