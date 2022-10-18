package Observer;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserObserved implements Observed {
    List<User> users = new ArrayList<>();
    List<Observer> subscribers = new ArrayList<>();

    public void addUser(User user) {
        this.users.add(user);
        notifyObservers();
    }

    public void removeUser(User user) {
        this.users.remove(user);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : subscribers) {
            observer.handleEvent(this.users);
        }
    }
}
