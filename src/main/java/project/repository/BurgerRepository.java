package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.Burger;

import java.util.List;

public interface BurgerRepository {
    List<Burger> getAllBurgers();
}
