package ru.academy.pizza.objects;

import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

//декоратор для добавление бекона в пиццу
public class BaconDecorator extends PizzaDecorator{
    private static final double EXTRA_BACON_COST = 100.0; // цена за дополнительный бекон в пицце

    public BaconDecorator(Pizza pizza) throws PriceException, SizeException {
        super(pizza);
    }

    //пеерасчет цены для пиццы с добавкой
    @Override
    public double calculatePrice() throws SizeException {
        return pizza.calculatePrice() + EXTRA_BACON_COST;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", дополнительный бекон";
    }
}
