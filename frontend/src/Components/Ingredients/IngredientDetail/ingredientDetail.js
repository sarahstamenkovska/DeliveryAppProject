import React,{useState,useEffect} from 'react'
import {useParams, useHistory, Link} from 'react-router-dom';
import axios from '../../../custom-axios/axios'
import IngredientsService from 'C:/Users/user37/Desktop/proekt/src/main/java/project/service/IngredientService.java'
import BurgerRow from "../BurgerRow/burgerRow";
import Veggie from './Veggie'

const IngredientDetail = (props) => {


        const [term,setTerm] = useState({});
        const [burgers, setBurgers] = useState([]);
        const {name} = useParams();
        const history = useHistory();

        useEffect(() => {
            axios.get("/rest/ingredients/"+name).then((data)=>{
                setTerm(data.data);
            })
        },[])

         useEffect(() => {
                IngredientsService.getIngredientBurgers(name).then(response => {
                    setBurgers(response.data);
                })
            }, []);

       let burgersView = burgers.map(burger => <BurgerRow burger={burger}/>);

       if (burgersView.length === 0) {
               burgersView = <span>None</span>
           }
    return (
        <div className="row">
                <h4 className="text-upper text-left col-12">Detail Ingredient</h4>

                  <div className="form-group row">
                       <div  name={"name"} className="col-12 text-left" ><b> Name:</b> {term.name} </div>
                       <div  name={"salad"}  className="col-12 text-left" ><b>Salad:</b>{term.salad} </div>
                       <div  name={"sauce"}  className="col-12 text-left" ><b>Sauce: </b>{term.sauce}</div>
                       <div  name={"spicy"}  className="col-12 text-left" ><b>Spicy: </b>{term.spicy}</div>

                       <div className="offset-sm-1 col-12  text-center">
                           <button className="btn btn-danger text-upper">
                              <Link to={"/ingredients"}>Cancel</Link>
                           </button>
                       </div>
                  </div>
                  <div><h2>Burgers: </h2>
                  {burgersView}
                  </div>
        </div>
    );
}



export default IngredientDetail;
