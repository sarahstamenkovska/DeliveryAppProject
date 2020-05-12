package project.service;

import project.model.Bread;
import project.model.Burger;
import project.model.Ingredient;

import java.util.List;

public interface BurgerService {

    List<Burger> listBurgers();
    List<Burger> listBurgersWithIngredients(String name);
    Burger getById(String id);

    Burger getByName(String name);

    Burger addNewBurger( String name, String description, Bread bread, List<Ingredient> ingredients);

    Burger editBurger(String name, String description, Bread bread, List<Ingredient> ingredients);

    void deleteBurger(String name);
}
