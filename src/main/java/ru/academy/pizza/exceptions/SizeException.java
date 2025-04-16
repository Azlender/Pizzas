package ru.academy.pizza.exceptions;

import ru.academy.pizza.objects.Pizza;

//исключение для некорректного размера пиццы
public class SizeException extends Throwable {
    public SizeException(Pizza.Size s) {
        super("Размер пиццы не может быть " + s);
    }
}
