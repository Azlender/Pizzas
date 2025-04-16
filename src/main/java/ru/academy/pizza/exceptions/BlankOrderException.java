package ru.academy.pizza.exceptions;

public class BlankOrderException extends Throwable {
    public BlankOrderException() {
        super("Клиент не заказал ни одной пиццы");
    }
}
