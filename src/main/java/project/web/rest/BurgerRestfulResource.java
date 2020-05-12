package project.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import project.model.Bread;
import project.model.Burger;
import project.model.Ingredient;
import project.service.impl.PersistentBurgerServiceImpl;
import project.service.impl.PersistentIngredientServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/rest/burgers")
public class BurgerRestfulResource {


    private PersistentBurgerServiceImpl persistentBurgerService;
    private PersistentIngredientServiceImpl persistentIngredientService;

    public BurgerRestfulResource(PersistentBurgerServiceImpl persistentBurgerService, PersistentIngredientServiceImpl persistentIngredientService){
        this.persistentBurgerService=persistentBurgerService;
        this.persistentIngredientService=persistentIngredientService;
    }


    @GetMapping("/{id}")
    public Burger getById(@PathVariable String id){
        return persistentBurgerService.getById(id);
    }

   @GetMapping
    public List<Burger> listBurgers()
   {
       return persistentBurgerService.listBurgers();
   }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Burger createBurger(@RequestParam("name") String name,
                               @RequestParam("description") String description,
                             @RequestParam(value = "bread") Bread bread,
                             @RequestParam(value = "ingredients") List<Ingredient> ingredients,
                             HttpServletResponse response,
                             UriComponentsBuilder builder){
        Burger newBurger=persistentBurgerService.addNewBurger(name,description,bread,ingredients);
        response.setHeader("Location", builder.path("/rest/burgers/{id}").buildAndExpand(newBurger.getName()).toUriString());
        return newBurger;
    }

    @PutMapping("/{id}")
    public Burger editBurger(@PathVariable String name,
                             @RequestParam("description") String description,
                             @RequestParam(value = "ingredients") List<Ingredient> ingredients,
                             @RequestParam(value = "bread") Bread bread){

        return persistentBurgerService.editBurger(name, description, bread, ingredients);
    }

    @DeleteMapping("/{id}")
    public void deleteBurger(@PathVariable String id) {
        persistentBurgerService.deleteBurger(id);
    }

}
