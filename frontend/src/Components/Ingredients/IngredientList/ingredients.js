import React from 'react';
import IngredientTerm from '../IngredientTerm/ingredientTerm'
import {Link} from "react-router-dom";
//ova e funkcionalna komponenta

const getIngredients = (props) => {

    const consultationTerms = props.terms.map((term,index)=> {
        //map da se izmapira site konsult i eden po eden obj se izminuva
        debugger;
        return (//props term koj tekovno go predavam
            <IngredientTerm onDelete={props.onDelete} name={term.name} term={term} key={index} colClass={"col-md-6 mt-2 col-sm-12"}/>
        );//ovde stom se povika onDELETE metodo da se povika ova metoda
    });

    const handlePageClick = (e) => {
        props.onPageClick(e.selected)
    }

    let LengthProps = props.terms.length;
    if(LengthProps === 0){
        return(
        <div>
            <div>No ingredients</div>
            <button className="btn btn-outline-secondary">
                <Link className="nav-link" to={"/ingredients/new"}>Add new ingredient</Link>
            </button>
        </div>
        )
    }
    else {
        return (
            <div className={"row"}>
                <div className="row">
                    <h4 className="text-upper text-left">Ingredients</h4>
                    <div className="table-responsive">
                        <table className="table tr-history table-striped small">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Salad</th>
                                <th scope="col">Spicy</th>
                                <th scope="col">Sauce</th>

                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                    <button className="btn btn-outline-secondary">
                        <Link className="nav-link" to={"/ingredients/new"}>Add new ingredient</Link>
                    </button>
                </div>
            </div>
        )
    }
}

export default getIngredients;