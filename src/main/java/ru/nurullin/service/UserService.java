package ru.nurullin.service;

import ru.nurullin.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    void delete(int id);

    void update(User user);

    User getById(int id);
}
