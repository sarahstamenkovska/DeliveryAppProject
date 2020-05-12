package project.model;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="burgers")
@NoArgsConstructor
public class Burger {

    @Id
    @Column(name = "name")
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "burger_order")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bread_name", referencedColumnName = "name")
    private Bread bread;

    @ManyToMany
    @JoinTable(name = "burger_ingredient",
            joinColumns = @JoinColumn(name = "burger_name"),
            inverseJoinColumns = @JoinColumn(name = "ingredient"))
    private List<Ingredient> ingredients;

    public Burger( String name, String description)
    {

        this.name=name;
        this.description=description;
    }

    public Burger( String name, String description, Bread bread, List<Ingredient> ingredients)
    {

        this.name=name;
        this.description=description;
        this.bread = bread;
        this.ingredients=ingredients;
    }


    public  Bread getBread() { return bread;}


    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


}
