package ru.academy.pizza.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

import java.util.HashSet;
import java.util.Set;
//класс для меню
public class Menu {
    private final Set<Dish> dishes;
    private static final Logger log = LogManager.getLogger(Menu.class);
//создаем меню со всеми возможными вариантами блюд
    public Menu() throws PriceException, SizeException {
        log.trace("Создаем меню");
        this.dishes = new HashSet<Dish>();
        addPizzas(dishes);


    }
//функция для добавления пицц, далее можно создать такие же функции, для добавления блюд другого типа
    public void addPizzas(Set<Dish> dishes_) throws PriceException, SizeException {
        log.info("На данный момент вы можете заказать:");
        dishes.add(new Hawaiian(Pizza.Size.SMALL, 400, "Гавайская"));
        dishes.add(new Hawaiian(Pizza.Size.MEDIUM, 400, "Гавайская"));
        dishes.add(new Hawaiian(Pizza.Size.LARGE, 400, "Гавайская"));
        dishes.add(new Margherita(Pizza.Size.SMALL, 300, "Маргаритта"));
        dishes.add(new Margherita(Pizza.Size.MEDIUM, 300, "Маргаритта"));
        dishes.add(new Margherita(Pizza.Size.LARGE, 300, "Маргаритта"));
        dishes.add(new Pepperoni(Pizza.Size.SMALL, 500, "Пепперони"));
        dishes.add(new Pepperoni(Pizza.Size.MEDIUM, 500, "Пепперони"));
        dishes.add(new Pepperoni(Pizza.Size.LARGE, 500, "Пепперони"));
    }
    //функция для вывода всех блюд в меню
    public void showMenu()
    {
        for (Dish dish : dishes) {
            log.info(dish.getDescription());
        }

    }
}
