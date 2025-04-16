package ru.academy.pizza.exceptions;

//исключение для пустого заказа
public class BlankOrderException extends Throwable {
    public BlankOrderException() {
        super("Клиент не заказал ни одной пиццы");
    }
}
