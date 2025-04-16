package ru.academy.pizza.exceptions;

public class KitchenOverloadException extends Throwable {
    public KitchenOverloadException(int e){
        super("Превышен лимит в " + e + " заказов");
    }
}
