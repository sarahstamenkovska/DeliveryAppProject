package project.repository.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.model.Ingredient;

public interface IngredientJpaRepository extends JpaRepository<Ingredient,String> {

    Ingredient findByName(String name);

    @Query("select i from Ingredient i where i.spicy=true")
    Page<Ingredient> getSpicy(Pageable pageable);

    @Query("select i from Ingredient i where i.salad=true")
    Page<Ingredient> getSalad(Pageable pageable);

    @Query("select i from Ingredient i where i.sauce=true")
    Page<Ingredient> getSauce(Pageable pageable);
}
