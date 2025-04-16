package ru.academy.pizza.objects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.academy.pizza.exceptions.PriceException;
import ru.academy.pizza.exceptions.SizeException;

//базовый класс для всех пицц
public abstract class Pizza extends Dish {
    private static final Logger log = LogManager.getLogger(Pizza.class);


    public enum Size { // размеры пиццы
        SMALL, MEDIUM, LARGE
    }

    protected final Size size;

    protected Pizza(Size size_, double basePrice_, String name_) throws PriceException, SizeException {
        super(basePrice_, name_);
        log.trace("Создаем новую пиццу типа '{}' размера {} стоимостью {}", name_, size_, basePrice_);

        //проверка размера на корректность
        log.debug("Проверяем значение размера");
        if (size_ != null) {
            this.size = size_;
        } else {

            throw new SizeException(null);
        }
    }


    public abstract double calculatePrice() throws SizeException;

    //информация о пицце
    @Override
    public String getDescription() {
        return name + " (" + size + ")";
    }

}
