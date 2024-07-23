package ru.nurullin.DAO;

import ru.nurullin.entity.Owner;

import java.util.List;

public interface OwnerDao {

    void save(Owner owner);

    Owner getById(int id);

    List<Owner> findAll();

    void update(Owner owner);

    void delete(int id);
}
