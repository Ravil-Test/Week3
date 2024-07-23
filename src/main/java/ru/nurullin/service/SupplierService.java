package ru.nurullin.service;

import ru.nurullin.entity.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();

    void save(Supplier supplier);

    void delete(int id);

    void update(Supplier supplier);

    Supplier getById(int id);
}
