package ru.academy.pizza.objects;

import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;
//декоратор для добавление доп сыра в пиццу
public class DoubleCheeseDecorator extends PizzaDecorator {
    private static final double EXTRA_CHEESE_COST = 50.0;

    public DoubleCheeseDecorator(Pizza pizza) throws PriceException, SizeException {
        super(pizza);
    }
    //пеерасчет цены для пиццы с добавкой
    @Override
    public double calculatePrice() throws SizeException {
        return pizza.calculatePrice() + EXTRA_CHEESE_COST;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", двойной сыр";
    }
}
