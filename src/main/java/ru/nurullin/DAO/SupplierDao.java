package ru.nurullin.DAO;

import ru.nurullin.entity.Supplier;

import java.util.List;

public interface SupplierDao {

    void save(Supplier supplier);

    Supplier getById(int id);

    List<Supplier> findAll();

    void update(Supplier supplier);

    void delete(int id);
}
