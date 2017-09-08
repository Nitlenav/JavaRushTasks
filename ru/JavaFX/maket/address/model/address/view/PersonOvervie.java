package ru.JavaFX.maket.address.model.address.view;

public class PersonOvervie {
    private static PersonOvervie ourInstance = new PersonOvervie();

    public static PersonOvervie getInstance() {
        return ourInstance;
    }

    private PersonOvervie() {
    }
}
