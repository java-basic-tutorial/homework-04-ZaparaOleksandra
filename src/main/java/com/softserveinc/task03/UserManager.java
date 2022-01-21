package com.softserveinc.task03;

import java.util.HashSet;
import java.util.Set;

public class UserManager {
    private final Set<User> users;

    public UserManager() {
        users = new HashSet<>();
    }

    public void register(String login, String password) {
        users.add(new User(login, password));
    }

    public void delete(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                users.remove(user);
                break;
            }
        }

    }
    private User find(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean exists(String login, String password) {
     return find(login, password) != null;
    }

    public boolean changePassword(String login, String oldPassword, String newPassword) {
     User user = find(login, oldPassword);
     if(user != null) {
         user.setPassword(newPassword);
         return true;

        }
     return false;
    }

}
