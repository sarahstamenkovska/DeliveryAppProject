import React, {Component} from 'react';
import Moment from "react-moment";
import {Link} from "react-router-dom";

class Veggie extends Component {

    render() {

        return (
        <div>
            <div>{this.spicy()}</div>
            <div>{this.salad()}</div>
            <div>{this.sauce()}</div>
        </div>
        );
    }
    spicy(){
        if (this.props.term) {
            debugger;

            return <div>true</div>;

        }else{
            return <div>false</div>
        }
    }
    salad(){
            if (this.props.term) {
                debugger;

                return <div>true</div>;

            }else{
                return <div>false</div>
            }
        }
    sauce(){
                if (this.props.term) {
                    debugger;

                    return <div>true</div>;

                }else{
                    return <div>false</div>
                }
            }

}


export default Veggie;