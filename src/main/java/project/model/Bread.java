package project.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Entity
@Table(name="bread")
public class Bread {

    @Id
    @Column(name = "name")
    private String name;


@OneToOne(mappedBy = "bread")
    private Burger burger;

    public Bread(String name)
    {
        this.name=name;
    }




}
