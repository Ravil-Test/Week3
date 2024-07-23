package ru.nurullin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.nurullin.DAO.SupplierDao;
import ru.nurullin.entity.Supplier;

import java.util.List;

@Service
public class SupplierServiceImp implements SupplierService {

    @Qualifier("getUserDao")
    @Autowired
    public SupplierDao supplierDao;

    public List<Supplier> findAll() {
        return supplierDao.findAll();
    }

    @Override
    public void save(Supplier supplier) {
        supplierDao.save(supplier);
    }

    @Override
    public void delete(int id) {
        supplierDao.delete(id);
    }

    @Override
    public void update(Supplier supplier) {
        supplierDao.update(supplier);
    }

    @Override
    public Supplier getById(int id) {
        return supplierDao.getById(id);
    }

}
