import React, {Component} from 'react';
import './App.css';
import Header from "../Header/header";
import Ingredients from '../Ingredients/IngredientList/ingredients'
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import IngredientsService from 'C:/Users/user37/Desktop/proekt/src/main/java/project/service/IngredientService.java'
import IngredientAdd from '../Ingredients/IngredientAdd/ingredientAdd'
import IngredientEdit from '../Ingredients/IngredientEdit/ingredientEdit'
import IngredientDetail from '../Ingredients/IngredientDetail/ingredientDetail'


class App extends Component {
  constructor(props) {//site konsultacii koi stojat vo state
    super(props);
    this.state = {//tekovnata sostojba si ja narekuvam terms
      terms: []
    }
  }

  componentDidMount() {
    this.loadIngredients();
  }

  loadIngredients = () => {
    IngredientsService.fetchIngredientTerms().then(response=>{
      this.setState((prevState)=>{//kako vlez ja imam prethodnata sostojba
        return {
          "terms":response.data.content//OVDE MI SE najduva podatocite vo content pod koja sakame da se renderira
          //ovde se vleguva vo upotreba na aplikacijata
        }
      })
    })
  }


  createIngredient = (newTerm) => {
    IngredientsService.addIngredientTerm(newTerm).then((response)=>{
      const newTerm = response.data;
      this.setState((prevState) => {//modifikacija na prethodnio state
        const newTermsRef = [...prevState.terms, newTerm];//dodavame element vo lista na terms toj so go dodadov a go dobivam od response
        //or
        //const terms = prevState.terms.concat(newTerm); //koncatenacija se kreira nova lista se dodava nov elem i na toj nacin state  se kreira nova referenca
        return {
          "terms": newTermsRef
        }
      });
    });
  }

  updateIngredient = ((editedTerm) => {
    IngredientsService.updateIngredientTerm(editedTerm).then((response)=>{
      const newTerm = response.data;
      this.setState((prevState) => {
        const newTermsRef = prevState.terms.map((item)=>{
          debugger;
          if (item.name===newTerm.name) {
            return newTerm;
          }
          return item;
        })
        return {
          "terms": newTermsRef
        }
      });
    });
  });


  deleteIngredient = (name) => {
    IngredientsService.deleteIngredientTerm(name).then((response)=>{
      this.setState((state) => {
        const terms = state.terms.filter((t) => {
          return t.name !== name;
        });
        return {terms}
      })
    })
  }

  render() {

    const routing = (
        <Router>
          <Header/>
          <main role="main" className="mt-3">

            <div className="container">
              <Route path={"/ingredients"} exact render={()=>
                  <Ingredients onPageClick={this.loadIngredients} terms={this.state.terms} onDelete={this.deleteIngredient}/>}>
              </Route>
              <Route path={"/ingredients/new"} render={()=><IngredientAdd onNewTermAdded={this.createIngredient}/>}>
              </Route>
              <Route path="/ingredients/:name/edit" render={()=>
                  <IngredientEdit onsubmitt={this.updateIngredient}/>}>
              </Route>
              <Route path="/ingredients/:name/details" render={()=>
                  <IngredientDetail />}>
              </Route>
              <Redirect to={"/ingredients"}/>
            </div>
          </main>
        </Router>
    )

    return (

        <div className="App">
          {routing}
        </div>
    );
  }
}

export default App;
