package ru.nurullin.service;

import ru.nurullin.entity.Owner;

import java.util.List;

public interface UserService {

    List<Owner> findAll();

    void save(Owner owner);

    void delete(int id);

    void update(Owner owner);

    Owner getById(int id);
}
