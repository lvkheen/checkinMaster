package com.lvkheen.service;

import com.lvkheen.dao.UserDao;
import com.lvkheen.entity.Location;
import com.lvkheen.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public User getUser(String username) {
        return userDao.getUser(username);
    }

    @Override
    public List<Location> getLocations() {
        return userDao.getLocations();
    }

    @Override
    public void deleteLocation(int id) {
        userDao.deleteLocation(id);
    }


    @Override
    public Location getLocation(int id) {
        return userDao.getLocation(id);
    }

    @Override
    public void saveLocation(Location location) {
        userDao.saveLocation(location);
    }


}
