package ru.academy.pizza.exceptions;

public class PriceException extends Throwable {
    public PriceException(double price) {
        super("Некорректна цена" + price);
    }
}
