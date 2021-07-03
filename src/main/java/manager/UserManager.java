package manager;

import exceptions.UserAlreadyExists;
import model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserManager {
    HashMap<String, User> userMap = new HashMap<>();

    public void addUser(User user) {
        if(userMap.containsKey(user.getName())) {
            throw new UserAlreadyExists();
        }
        userMap.put(user.getName(), user);
    }

    public User getUser(String name) {
        if(!userMap.containsKey(name)) {
            throw new UserAlreadyExists();
        }
        return userMap.get(name);
    }

    public Collection<User> getUsers()
    {
        //users.values()
        return userMap.values();
    }


}
