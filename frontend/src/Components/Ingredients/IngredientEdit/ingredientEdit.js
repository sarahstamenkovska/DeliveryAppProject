import React,{useState,useEffect} from 'react'
import {useParams, useHistory, Link} from 'react-router-dom';
import axios from 'C:/Users/user37/Desktop/proekt/frontend/src/custom-axios/axios'

const IngredientEdit = (props) => {

    const [term,setTerm] = useState({});
    const {name} = useParams();
    const history = useHistory();

    useEffect(() => {
        axios.get("/rest/ingredients/"+name).then((data)=>{
            setTerm(data.data);
        })
    },[])

    const onFormSubmit = (e) => {
        e.preventDefault();
        debugger;
        console.log(e);
        console.log(e.target.name.value);

        const newTerm= {

            "name":e.target.name.value,
            "salad": e.target.salad.checked,
            "sauce": e.target.sauce.checked,
            "spicy": e.target.spicy.checked

        }
        props.onsubmit(newTerm);

        history.push("/ingredients");

    }

    const handleTermOnChange  = (e) => {
        const paramName = e.target.name;
        const paramValue = e.target.value;
        setTerm({paramName:paramValue});
    }

    return (
        <div className="row">
            <form className="card" onSubmit={onFormSubmit}>
                <h4 className="text-upper text-left">Edit Ingredient</h4>
                <div className="form-group row">
                    <label htmlFor="ingredient" className="col-sm-4 offset-sm-1 text-left">Ingredient name</label>
                    <div className="col-sm-6">
                        <input type="text" value={term.name} name={"name"} onChange={handleTermOnChange} className="form-control" id="ingredient" placeholder="Ingredient name" maxLength="50"/>
                    </div>
                </div>
                <div className="form-group row">
                                    <label htmlFor="salad" className="col-sm-4 offset-sm-1 text-left">Salad</label>
                                    <div className="col-sm-6 col-xl-4">
                                        <input type="checkbox" name={"salad"} value={term.salad} onChange={handleTermOnChange} checked={term.salad}className="form-control" id="salad"/>
                                    </div>
                                </div>
                <div className="form-group row">
                    <label htmlFor="sauce" className="col-sm-4 offset-sm-1 text-left">Sauce</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="checkbox" name={"sauce"} value={term.sauce} onChange={handleTermOnChange} checked={term.sauce}className="form-control" id="sauce"/>
                    </div>
                </div>

                <div className="form-group row">
                    <label htmlFor="spicy" className="col-sm-4 offset-sm-1 text-left">Spicy</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="checkbox" name={"spicy"} value={term.spicy} onChange={handleTermOnChange} checked={term.spicy} className="form-control" id="spicy"/>
                    </div>
                </div>

                <div className="form-group row">
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button
                            type="submit"
                            className="btn btn-primary text-upper">
                            Save
                        </button>
                    </div>
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button
                                className="btn btn-warning text-upper">
                            <Link to={"/ingredients"}>Reset</Link>
                        </button>
                    </div>
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button
                            className="btn btn-danger text-upper">
                            <Link to={"/ingredients"}>Cancel</Link>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    )
}

export default IngredientEdit;
