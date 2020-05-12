package project.repository.InMemoryImpl;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import project.bootstrap.DataHolder;
import project.model.Burger;
import project.repository.BurgerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBurgerRepositoryImpl implements BurgerRepository {


    @Override
    public List<Burger> getAllBurgers() {
        return new ArrayList<>(DataHolder.burgers);
    }


}
