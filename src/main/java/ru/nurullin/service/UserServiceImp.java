package ru.nurullin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.nurullin.DAO.OwnerDao;
import ru.nurullin.entity.Owner;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Qualifier("getUserDao")
    @Autowired
    public OwnerDao ownerDao;

    public List<Owner> findAll() {
        return ownerDao.findAll();
    }

    @Override
    public void save(Owner owner) {
        ownerDao.save(owner);
    }

    @Override
    public void delete(int id) {
        ownerDao.delete(id);
    }

    @Override
    public void update(Owner owner) {
        ownerDao.update(owner);
    }

    @Override
    public Owner getById(int id) {
        return ownerDao.getById(id);
    }

}
