package ru.academy.pizza.objects;

import ru.academy.pizza.exceptions.BlankOrderException;
import ru.academy.pizza.exceptions.KitchenOverloadException;
import ru.academy.pizza.exceptions.SizeException;

public interface IKitchen {
    void processOrder(Order order) throws KitchenOverloadException, SizeException, BlankOrderException;

    boolean isOverload() throws KitchenOverloadException;
}
