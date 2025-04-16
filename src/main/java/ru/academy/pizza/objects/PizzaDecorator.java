package ru.academy.pizza.objects;

import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

public abstract class PizzaDecorator extends Pizza {
    protected final Pizza pizza;

    public PizzaDecorator(Pizza pizza) throws PriceException, SizeException {
        super(pizza.size, pizza.basePrice, pizza.name);
        this.pizza = pizza;
    }
}