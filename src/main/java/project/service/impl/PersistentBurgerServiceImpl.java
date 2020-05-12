package project.service.impl;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.Bread;
import project.model.Burger;
import project.model.Ingredient;
import project.repository.BurgerRepository;
import project.repository.jpa.BurgerJpaRepository;
import project.repository.jpa.IngredientJpaRepository;
import project.service.BurgerService;

import java.util.List;
@NoArgsConstructor
@Service
public class PersistentBurgerServiceImpl implements BurgerService {

    private BurgerJpaRepository burgerJpaRepository;
    private IngredientJpaRepository ingredientJpaRepository;

    public PersistentBurgerServiceImpl(BurgerJpaRepository burgerJpaRepository, IngredientJpaRepository ingredientJpaRepository)
    {
        this.burgerJpaRepository=burgerJpaRepository;
        this.ingredientJpaRepository=ingredientJpaRepository;
    }

    @Override
    public List<Burger> listBurgers() {
        return burgerJpaRepository.findAll();
    }

    @Override
    public List<Burger> listBurgersWithIngredients(String name) {
        return burgerJpaRepository.getAllByIngredientName(name);
    }

    @Override
    public Burger getById(String name) {
        return burgerJpaRepository.findByName(name);

    }


    @Override
    public Burger getByName(String name) {
        return burgerJpaRepository.findByName(name);
    }

    @Override
    public Burger addNewBurger( String name, String description, Bread bread, List<Ingredient> ingredients) {
       Burger newBurger=new Burger(name,description,bread,ingredients);
       return burgerJpaRepository.save(newBurger);
    }

    @Override
    public Burger editBurger(String name, String description, Bread bread, List<Ingredient> ingredients) {
       Burger burger=burgerJpaRepository.findByName(name);
       burger.setName(name);
       burger.setDescription(description);
       burger.setIngredients(ingredients);
       burger.setBread(bread);
       burgerJpaRepository.save(burger);
       return burger;


    }

    @Override
    public void deleteBurger(String name) {
        Burger burger=burgerJpaRepository.findByName(name);
        burgerJpaRepository.delete(burger);

    }
}
