package project.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.model.Burger;
import project.model.Ingredient;

import java.util.List;
import java.util.Optional;

public interface BurgerJpaRepository extends JpaRepository<Burger, String> {
    @Query("select b from Burger b join b.ingredients i where i.name=:name")
    List<Burger> getAllByIngredientName(@Param("name") String name);

    Burger findByName(String name);






    @Query("select * from Burger")
    List<Burger> findAll();


    @Query("select i from Burger b join b.ingredients i where b.name=:burgerName")
    List<Ingredient> getIngredients(@Param("burgerName") String burgerName);





}
