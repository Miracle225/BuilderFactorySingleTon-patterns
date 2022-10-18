package Observer;

import models.User;

import java.util.List;

public interface Observer {
    public void handleEvent(List<User> users);
}
