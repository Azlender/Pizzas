package ru.academy.pizza.objects;

import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

public class BaconDecorator extends PizzaDecorator{
    private static final double EXTRA_BACON_COST = 100.0;

    public BaconDecorator(Pizza pizza) throws PriceException, SizeException {
        super(pizza);
    }

    @Override
    public double calculatePrice() throws SizeException {
        return pizza.calculatePrice() + EXTRA_BACON_COST;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", дополнительный бекон";
    }
}
