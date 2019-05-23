package ru.academit.mikhajlov.Converter;

import ru.academit.mikhajlov.Main.TemperatureConverter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class LibraryClass {
    double convert(Object object, String type, double number) {
        double result = 0;

        Class classObject = object.getClass();

        for (Method method : classObject.getDeclaredMethods()) {
            TemperatureConverter.Flag annotation = method.getAnnotation(TemperatureConverter.Flag.class);

            if (Objects.equals(annotation.flag(), type)) {
                try {
                    result = (double) method.invoke(object, number);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}

