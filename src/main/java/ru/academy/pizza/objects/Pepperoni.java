package ru.academy.pizza.objects;

import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

public class Pepperoni extends Pizza {
    private final double SMALL_COEFFICIENT = 1;// бызовый множитель маленькой пиццы
    private final double MEDIUM_COEFFICIENT = 1.2; // множитель стоимости пиццы относительно базовой для средней пиццы
    private final double LARGE_COEFFICIENT = 1.4; // множитель стоимости пиццы относительно базовой для средней пиццы

    public Pepperoni(Size size_, double price_, String name_) throws PriceException, SizeException {
        super(size_, price_, name_);
    }

    // Переопределяем метод рассчета цены для пеперони
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
