package ru.vsu.bank.store;

import ru.vsu.bank.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author agavshin
 * @date 26.09.18
 */
public class UserManager {

    private Map<String, User> users = new HashMap<String, User>();

    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    private UserManager() {
    }

    public void addUser(User user) {
        String key = user.getLogin() + "#" + user.getPassword();
        users.put(key, user);
    }

    public User getUser(String login, String password) {
        String key = login + "#" + password;
        return users.get(key);
    }
}
