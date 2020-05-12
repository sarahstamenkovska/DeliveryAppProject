package project.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import project.model.Ingredient;
import project.repository.jpa.IngredientJpaRepository;
import project.service.IngredientService;

public class PersistentIngredientServiceImpl implements IngredientService {

    private IngredientJpaRepository ingredientJpaRepository;

    public PersistentIngredientServiceImpl(IngredientJpaRepository ingredientJpaRepository)
    {
        this.ingredientJpaRepository=ingredientJpaRepository;
    }


    @Override
    public Ingredient addNewIngredient(String name, boolean spicy, boolean salad, boolean sauce) {


        Ingredient existingIngredient=ingredientJpaRepository.findByName(name);


        Ingredient newIngredient=new Ingredient(name,spicy,salad,sauce);
        return ingredientJpaRepository.save(newIngredient);
    }

    @Override
    public Ingredient editIngredient(String id, boolean spicy, boolean salad, boolean sauce) {
        Ingredient ingredient= ingredientJpaRepository.findByName(id);
        ingredient.setSpicy(spicy);
        ingredient.setSalad(salad);
        ingredient.setSauce(sauce);
        ingredient.setName(id);
        ingredientJpaRepository.save(ingredient);
        return ingredient;
    }

    @Override
    public void deleteIngredient(String id) {
        Ingredient ingredient= ingredientJpaRepository.findByName(id);
        ingredientJpaRepository.delete(ingredient);
    }
    @Override
    public Page<Ingredient> getAllIngredients(int page, int size) {
        Pageable pageData= PageRequest.of(page,size, Sort.by("name"));
        return ingredientJpaRepository.findAll(pageData);
    }

    @Override
    public Ingredient getById(String id) {
        return ingredientJpaRepository.findByName(id);
    }

    @Override
    public Page<Ingredient> getSpicy(int page, int size) {
        Pageable pageData=PageRequest.of(page,size);
        return ingredientJpaRepository.getSpicy(pageData);    }

    @Override
    public Page<Ingredient> getSalad(int page, int size) {
        Pageable pageData=PageRequest.of(page,size);
        return ingredientJpaRepository.getSalad(pageData);    }

    @Override
    public Page<Ingredient> getSauce(int page, int size) {
        Pageable pageData=PageRequest.of(page,size);
        return ingredientJpaRepository.getSauce(pageData);    }


}
