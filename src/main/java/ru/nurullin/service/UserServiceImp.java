package ru.nurullin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.nurullin.DAO.UserDao;
import ru.nurullin.DAO.UserDaoImp;
import ru.nurullin.entity.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Qualifier("getUserDao")
    @Autowired
    public UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

}
