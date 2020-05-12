import React from 'react'
import {Link, Redirect,useHistory} from 'react-router-dom';

const IngredientAdd = (props) => {
    let valid=false;
    const history = useHistory();

    const onFormSubmit = (e) => {//pva onForm Submit se izvrsuva ko ce se klikni na kopceto zacuvaj i da ja obrabotam taa forma
        //vnatre se kreira event koj se keira pri klik na kopceto
        e.preventDefault();//za da izbegneme CALLL BACK PAZI!!!server povici
        debugger;//za da vidime so ima vo ovaj event e
        console.log(e);

            const newTerm = {
                "name": e.target.name.value,
                "spicy": e.target.spicy.value,
                "salad": e.target.salad.value,
                "sauce": e.target.sauce.value
            };
            if(newTerm.salad === "" || newTerm.name ==="" || newTerm.sauce==="" || newTerm.spicy===""){
                valid=false;
                return valid;
            }
            else {
                valid=true;
                props.onNewTermAdded(newTerm);//ova onNEWTermADDED go ima vo appjs go ceka ko ce se
                //funkcijata ja prativ kako property
                history.push("/ingredients")
            }
    }

    return (//jsx template koja treba da ja vrajca ova forma
        <div className="row">
            <form className="card" onSubmit={onFormSubmit}>
                <h4 className="text-upper text-left">Add Ingredient</h4>
                <div className="form-group row">
                    <label htmlFor="ingredient" className="col-sm-4 offset-sm-1 text-left " >Ingredient name</label>
                    <div className="col-sm-6">
                        <input type="text" name={"name"}  className="form-control" id="ingredient" placeholder="Ingredient name" maxLength="50"/>
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="amount" className="col-sm-4 offset-sm-1 text-left" >Amount</label>
                    <div className="col-sm-6">
                        <input type="text" name={"amount"} className="form-control" id="amount" placeholder="Amount" maxLength="50"/>
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="veggie" className="col-sm-4 offset-sm-1 text-left">Veggie</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="checkbox" name={"veggie"} className="form-control" id="veggie"/>
                    </div>
                </div>

                <div className="form-group row">
                    <label htmlFor="spicy" className="col-sm-4 offset-sm-1 text-left">Spicy</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="checkbox" name={"spicy"} className="form-control" id="spicy"/>
                    </div>
                </div>

                <div className="form-group row">
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button type="submit"className="btn btn-primary text-upper" disabled={valid}>
                            Save
                        </button>
                    </div>
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button
                            className="btn btn-warning text-upper">
                            <Link to={"/ingredients/new"}>Reset</Link>
                        </button>
                    </div>
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button
                            className="btn btn-danger text-upper">
                            <Link to={"/ingredients"}>Cencel</Link>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    )
}

export default IngredientAdd;