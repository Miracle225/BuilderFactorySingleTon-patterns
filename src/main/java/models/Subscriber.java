package models;

import Observer.Observer;

import java.util.List;

public class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handleEvent(List<User> users) {
        System.out.println("Dear " + name + "\nYou have some new users to watch\n"+ users +
                "\n------------------\n");
    }
}
