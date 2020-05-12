package project.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="ingredients")
public class Ingredient {

    @Id
    private String name;

    private boolean salad;

    private boolean spicy;


    private boolean sauce;

    public Ingredient() {
    }

    public Ingredient(String name, boolean spicy, boolean salad, boolean sauce) {
        this.name = name;
        this.spicy = spicy;
        this.salad = salad;
        this.sauce = sauce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public boolean isSalad() {
        return salad;
    }

    public void setSalad(boolean salad) {
        this.salad = salad;
    }

    public boolean isSauce() {
        return sauce;
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }
}
