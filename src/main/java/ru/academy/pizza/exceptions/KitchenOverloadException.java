package ru.academy.pizza.exceptions;

//исключение для перегруженной кухни
public class KitchenOverloadException extends Throwable {
    public KitchenOverloadException(int e){
        super("Превышен лимит в " + e + " заказов");
    }
}
