package ru.academy.pizza.objects;

import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

//гавайская пицца
public class Hawaiian extends Pizza {
    private final double SMALL_COEFFICIENT = 1;   // множитель для маленькой пиццы
    private final double MEDIUM_COEFFICIENT = 1.15; // множитель для средней пиццы
    private final double LARGE_COEFFICIENT = 1.35;  // множитель для большой пиццы

    public Hawaiian(Size size_, double price_, String name_) throws PriceException, SizeException {
        super(size_, price_, name_);
    }

    // Переопределяем метод рассчета цены для Гавайской пиццы
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
