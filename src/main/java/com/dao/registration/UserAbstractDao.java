package com.dao.registration;

import com.google.inject.ImplementedBy;
import com.models.User;

import java.util.List;

@ImplementedBy(com.dao.registration.UserDao.class)
public interface UserAbstractDao {
    public void saveUser(User user);

    public List<User> getAllUsers();

    public void removeUser(User user);

    public User getUserByEmail(String email);
}