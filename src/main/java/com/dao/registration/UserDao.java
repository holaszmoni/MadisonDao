package com.dao.registration;

import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;
import com.models.User;

import java.util.List;

public class UserDao implements UserAbstractDao {
    @Override
    public void saveUser(User user) {
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.REGISTER_USERS_LIST, user);
    }

    @Override
    public List<User> getAllUsers() {
        return SerenitySessionUtils.getFromSession(SerenityKeyConstants.REGISTER_USERS_LIST);
    }

    @Override
    public void removeUser(User user) {
        SerenitySessionUtils.removeObjectFromSerenitySessionList(SerenityKeyConstants.REGISTER_USERS_LIST, user);
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> users = getAllUsers();
        //filtrare
        return users.parallelStream().filter(item -> item.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }
}
