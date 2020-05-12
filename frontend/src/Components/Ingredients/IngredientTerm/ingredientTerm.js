import React, {Component} from 'react';
import Moment from "react-moment";
import {Link} from "react-router-dom";

class IngredientTerm extends Component {

    render() {

        return (//props e soodvetnio ingredient
                <tr className="ingredients">
                            <td scope="col">{this.props.term.name}</td>
                            <td scope="col">{this.salad()}
                            </td>
                            <td scope="col">{this.spicy()}
                            </td>
                            <td scope="col">{this.sauce()}
                            </td>
                            <td scope="col">
                                <button className="btn btn-sm btn-secondary">
                                    <span className="fa fa-edit"/>
                                    <Link className="btn btn-default" to={"/ingredients/"+this.props.name+"/details"}>Details</Link>
                                </button>
                                <a onClick={()=>this.props.onDelete(this.props.name)} className="btn btn-danger" title="Избриши">
                                    <i className="fa fa-trash">Remove</i>
                                </a>

                                <button className="btn btn-sm btn-outline-dark">
                                    <Link className="btn btn-default" to={"/ingredients/"+this.props.name+"/edit"}><i className="fa fa-pencil"></i>Edit</Link>
                                </button>
                            </td>
                </tr>

        );
    }
    salad(){
            if (this.props.term.salad) {
                return <div>true</div>;

            }else{
                return <div>false</div>
            }
        }
    spicy(){
        if (this.props.term.spicy) {
            return <div>true</div>;

        }else{
            return <div>false</div>
        }
    }
    sauce(){
        if (this.props.term.sauce ) {
            return <div>true</div>;

        }else{
            return <div>false</div>
        }
    }

}


export default IngredientTerm;