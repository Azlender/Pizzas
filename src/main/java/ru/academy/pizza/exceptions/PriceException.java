package ru.academy.pizza.exceptions;

//исключение для некорректной цены
public class PriceException extends Throwable {
    public PriceException(double price) {
        super("Некорректна цена" + price);
    }
}
