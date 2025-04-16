package ru.academy.pizza.exceptions;

import ru.academy.pizza.objects.Pizza;

public class SizeException extends Throwable {
    public SizeException(Pizza.Size s) {
        super("Размер пиццы не может быть " + s);
    }
}
