package ru.academy.pizza.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.academy.pizza.exceptions.BlankOrderException;
import ru.academy.pizza.exceptions.KitchenOverloadException;
import ru.academy.pizza.exceptions.SizeException;

public class PizzaKitchen implements IKitchen {
    private static final Logger log = LogManager.getLogger(PizzaKitchen.class);


    private static final int MAX_ORDERS = 20;
    private int currentOrders = 0;

    // Синглтон: приватный конструктор и статическая ссылка
    private static final PizzaKitchen instance = new PizzaKitchen();


    // приватный конструктор
    private PizzaKitchen() {

    }

    public static PizzaKitchen getInstance() {
        log.trace("Получаем единственный экземпляр кухни");
        return instance;
    }


    //Обработка заказа
    @Override
    public void processOrder(Order order) throws SizeException, BlankOrderException, KitchenOverloadException {

        if (isOverload()) {
            throw new KitchenOverloadException(MAX_ORDERS);
        } else {
            currentOrders++;
            order.printOrderDetails();
            log.info("Готовим заказ...");
            log.info("Заказ завершён.\n");
            currentOrders--;
        }
    }


    @Override
    public boolean isOverload(){
        log.debug("Проверяем загруженность кухни");
        return currentOrders >= MAX_ORDERS;
    }
}
