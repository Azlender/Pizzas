package ru.academy.pizza.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

//абстрактный класс для всех блюд
public abstract class Dish {
    private static final Logger log = LogManager.getLogger(Dish.class);
    protected final double basePrice; // цена за базовое блюдо
    protected final String name;
    static final double MAX_PRICE = 50000.0;//максимальная цена блюда


    protected Dish(double basePrice_, String name) throws PriceException {
        log.debug("Проверяем значение цены");
        if (basePrice_ >= 0 && basePrice_ <= MAX_PRICE) {
            this.basePrice = basePrice_;
        } else {
            throw new PriceException(basePrice_);
        }

        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public abstract double calculatePrice() throws SizeException;
    //метод для получения информация о блюде
    public String getDescription() {
        return name;
    }
}
