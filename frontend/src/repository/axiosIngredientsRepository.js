import axios from '../custom-axios/axios'
import qs from 'qs'

const IngredientsService = {
    fetchIngredientTerms: ()=> {
        return axios.get("/rest/ingredients");
    },
    fetchConsultationTermsPaged:(page,pageSize)=>{
        return axios.get("/rest/ingredients",{
            headers: {
                'page':page,'page-size':pageSize
            }
        })
    },

    getIngredientBurgers: (name) => {
        return axios.get(`/rest/ingredients/${name}/burgers`);
    },

    addIngredientTerm: (term) => {
        const data = {
            ...term,
            name:term.name//obj imase room pa nov obj pa name posle
            //
        }
        const formParams = qs.stringify(data);//za convert  json vo query string oti ni treba key value nas
        return axios.post("/rest/ingredients",formParams);
    },
    deleteIngredientTerm: (name) => {
        return axios.delete(`/rest/ingredients/${name}`);
    },
    updateIngredientTerm : (term) => {
        const data = {
            ...term,
        }
        const name= term.name;
        const formParams = qs.stringify(data);
        return axios.patch("/rest/ingredients/"+name,formParams,{
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }
        });
    },

}

export default IngredientsService;