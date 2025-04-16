package ru.academy.pizza.objects;

import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

//пицца маргарита
public class Margherita extends Pizza {
    private final double SMALL_COEFFICIENT = 1;   // множитель для маленькой пиццы
    private final double MEDIUM_COEFFICIENT = 1.1; // множитель для средней пиццы
    private final double LARGE_COEFFICIENT = 1.3;  // множитель для большой пиццы

    public Margherita(Size size_, double price_, String name_) throws PriceException, SizeException {
        super(size_, price_, name_);
    }

    // Переопределяем метод рассчета цены для Маргариты
    @Override
    public double calculatePrice() throws SizeException {
        return switch (size) {
            case SMALL -> basePrice * SMALL_COEFFICIENT;
            case MEDIUM -> basePrice * MEDIUM_COEFFICIENT;
            case LARGE -> basePrice * LARGE_COEFFICIENT;
            default -> throw new SizeException(size);
        };
    }
}
