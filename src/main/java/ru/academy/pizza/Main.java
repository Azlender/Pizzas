package ru.academy.pizza;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.academy.pizza.exceptions.BlankOrderException;
import ru.academy.pizza.exceptions.KitchenOverloadException;
import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;
import ru.academy.pizza.objects.*;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        try {
            //создание пицц
            Pizza margherita = new Margherita(Pizza.Size.MEDIUM, 300.0, "Маргарита");
            Pizza pepperoni = new Pepperoni(Pizza.Size.LARGE, 400.0, "пеперони");

            // Создание заказа от клиента
            Order order = new Order("Иван");

            // Добавление пицц в заказ
            order.addDish(margherita);
            order.addDish(pepperoni);
            order.addDish(new DoubleCheeseDecorator(margherita));
            // Обработка заказа на кухне
            PizzaKitchen pizzaKitchen = PizzaKitchen.getInstance();
            pizzaKitchen.processOrder(order);

            Menu menu = new Menu();
            menu.showMenu();
        } catch (PriceException | SizeException | BlankOrderException | KitchenOverloadException e) {
            log.error("Ошибка при обработке заказа: {}", e.getMessage());
        }
    }
}
