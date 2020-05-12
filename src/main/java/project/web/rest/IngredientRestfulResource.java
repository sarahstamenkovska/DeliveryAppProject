package project.web.rest;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import project.model.Burger;
import project.model.Ingredient;
import project.service.impl.PersistentBurgerServiceImpl;
import project.service.impl.PersistentIngredientServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.List;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rest/ingredients")
public class IngredientRestfulResource {

    private PersistentIngredientServiceImpl persistentIngredientService;
    private PersistentBurgerServiceImpl persistentBurgerService;

    public IngredientRestfulResource(PersistentIngredientServiceImpl persistentIngredientService, PersistentBurgerServiceImpl persistentPizzaService){
        this.persistentIngredientService=persistentIngredientService;
        this.persistentBurgerService=persistentBurgerService;
    }

    @GetMapping
    public Page<Ingredient> getAllIngredients(@RequestHeader(name = "page", defaultValue = "0", required = false) int page,
                                              @RequestHeader(name = "page-size", defaultValue = "5", required = false) int size,
                                              @RequestParam(value = "spicy", required = false) boolean spicy,
                                              @RequestParam(value = "salad", required = false) boolean salad ,
                                              @RequestParam(value = "sauce", required = false) boolean sauce )

    {

        if(spicy)
            return persistentIngredientService.getSpicy(page, size);
        else if(salad)
            return persistentIngredientService.getSalad(page, size);
        else if(sauce)
            return persistentIngredientService.getSauce(page, size);
        else
            return persistentIngredientService.getAllIngredients(page,size);


    }





    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient createIngredient(@RequestParam("name") String name,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam("salad") boolean salad,
                                       @RequestParam("sauce") boolean sauce,
                                       HttpServletResponse response,
                                       UriComponentsBuilder builder){

        Ingredient newIngredient=persistentIngredientService.addNewIngredient(name,spicy,salad,sauce);
        response.setHeader("Location", builder.path("/rest/ingredients/{id}").buildAndExpand(newIngredient.getName()).toUriString());
        return newIngredient;
    }

    @PatchMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable String id,
                                       @RequestParam("spicy") boolean spicy,
                                       @RequestParam("salad") boolean salad,
                                       @RequestParam("sauce") boolean sauce) {
        return persistentIngredientService.editIngredient(id, spicy, salad, sauce);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable String id) {
        persistentIngredientService.deleteIngredient(id);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable String id){
        return persistentIngredientService.getById(id);
    }


}
