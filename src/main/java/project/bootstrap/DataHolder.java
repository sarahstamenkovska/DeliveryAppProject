package project.bootstrap;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.model.Bread;
import project.model.Burger;
import project.model.Order;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Getter
public class DataHolder {

        public static final List<Burger> burgers = new ArrayList<>();
        public static final List<Order> orders = new ArrayList<>();
        public static final List<Bread> breads = new ArrayList<>();

        @PostConstruct
        public void init() {
            burgers.add(new Burger( "Classic Burger","Бургер, Леб, Јунешка плескавица, Кисели краставички, Кромид, Сенф, Кечап"));
            burgers.add(new Burger( "Classic Cheeseburger","Бургер, Леб, Јунешка плескавица,Млечен кашкавал, Кисели краставички, Кромид, Сенф, Кечап"));
            burgers.add(new Burger( "Double Cheeseburger","Бургер, Леб, Јунешка плескавица,Двојно повеќе кашкавал, Кисели краставички, Ајсберг, Кромид, Сенф, Бургер сос"));
            burgers.add(new Burger( "Bacon Burger","Бургер, Леб, Јунешка плескавица,Крцкава сланина, Кисели краставички, Ајсберг, Кромид, Сенф, Кечап"));
            burgers.add(new Burger( "FH Burger","Бургер, Леб, Јунешка плескавица, Крцкава сланина, Млечен кашкавал, Кисели краставички, Ајсберг, Кромид, Сенф, Кечап"));
            burgers.add(new Burger( "Premium FH Burger","Бургер, Леб, Јунешка плескавица, Чедар, Крцкава сланина, Млечен кашкавал, Кисели краставички, Ајсберг, Кромид, Сенф, Кечап"));
            burgers.add(new Burger( "Double Cheddar Burger","Бургер, Леб, Јунешка плескавица, 2xЧедар, Кисели краставички, Кромид, Сенф, Кечап"));
            burgers.add(new Burger("Monster Burger","Бургер, Леб, 2xЈунешка плескавица, Марула, Кисели краставички, Кромид, Домат, Сенф, Кечап"));
            burgers.add(new Burger( "American Burger","Бургер, Леб, Јунешка плескавица, Чедар, Крцкава сланина, Домат, Кисели краставички, Марула, Кромид, Сенф, Кечап"));
            burgers.add(new Burger("Chicken Burger","Бургер, Леб,  Пилешки стек, Кисели краставички, Домат, Кромид, ФХ чикен сос"));
            burgers.add(new Burger( "Crispy Chicken Burger","Бургер, Леб,  Пилешки стек во темпура, Кисели краставички, Домат, ФХ чикен сос"));
            burgers.add(new Burger( "Bacon Crispy Chicken Burger","Бургер, Леб,  Пилешки стек во темпура, Крцкава сланина, Кисели краставички, Домат, ФХ чикен сос"));
            burgers.add(new Burger( "Double Cheese Crispy Chicken Burger","Бургер, Леб,  Пилешки стек во темпура, Двојно повеќе млечен кашкавал, Кисели краставички, Домат, ФХ чикен сос"));
            burgers.add(new Burger( "FH Crispy Chicken Burger","Бургер, Леб,  Пилешки стек во темпура, Двојно повеќе млечен кашкавал, Крцкава сланина, Кисели краставички, Домат, ФХ чикен сос"));

            breads.add(new Bread("интегрален леб"));
            breads.add(new Bread("бел леб"));

            // orders.add(new Order("cv","cd","cdc"));
        }
}
