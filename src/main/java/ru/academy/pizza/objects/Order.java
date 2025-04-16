package ru.academy.pizza.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.academy.pizza.exceptions.BlankOrderException;
import ru.academy.pizza.exceptions.SizeException;

import java.util.ArrayList;
import java.util.List;

//класс для заказа

public class Order {
    private static final Logger log = LogManager.getLogger(Order.class);
    private final List<Dish> dishes;
    private final String customerName;


    public Order(String customerName_) {
        this.dishes = new ArrayList<>();
        this.customerName = customerName_;
    }

    //добавляем пиццу в заказ
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    //рассчет итоговой стоимости заказа
    public double getTotalPrice() throws SizeException, BlankOrderException {
        double total = 0.0;
        if (!dishes.isEmpty()) {
            for (Dish dish : dishes) {
                total += dish.calculatePrice();
            }
            return total;
        } else {
            throw new BlankOrderException();
        }
    }

    //детальная информация о заказе
    public void printOrderDetails() throws SizeException, BlankOrderException {
        log.info("Клиент {} заказал {} блюд(а)", customerName, dishes.size());

        for (Dish dish : dishes) {
            log.info("- {}", dish.getDescription());
        }

        log.info("Общая цена - {}р.", getTotalPrice());
    }


}
