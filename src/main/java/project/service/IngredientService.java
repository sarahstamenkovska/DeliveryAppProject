package project.service;

import org.springframework.data.domain.Page;
import project.model.Ingredient;

public interface IngredientService {
    Ingredient addNewIngredient(String name, boolean spicy, boolean salad, boolean sauce);
    Ingredient editIngredient(String id,boolean spicy, boolean salad, boolean sauce);
    void deleteIngredient(String id);
    Page<Ingredient> getAllIngredients(int page, int size);
    Ingredient getById(String id);
    Page<Ingredient> getSpicy(int page, int size);
    Page<Ingredient> getSalad(int page,int size);
    Page<Ingredient> getSauce(int page,int size);
}
