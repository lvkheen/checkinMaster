package com.lvkheen.service;

import com.lvkheen.entity.CrmUser;
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
    @Transactional
    public List<Location> getLocations() {
        return userDao.getLocations();
    }

    @Override
    @Transactional
    public void deleteLocation(int id) {
        userDao.deleteLocation(id);
    }


    @Override
    @Transactional
    public Location getLocation(int id) {
        return userDao.getLocation(id);
    }

    @Override
    @Transactional
    public void saveLocation(Location location) {
        userDao.saveLocation(location);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        userDao.deleteUser(username);
    }

    @Override
    @Transactional
    public void saveUser(CrmUser crmUser) {
        userDao.saveUser(crmUser);
    }

    @Override
    @Transactional
    public void banUser(String username) {
        userDao.banUser(username);
    }

    @Override
    @Transactional
    public void restoreUser(String username) {
        userDao.restoreUser(username);
    }

    @Override
    @Transactional
    public void setAdmin(String username) {
        userDao.setAdmin(username);
    }

    @Override
    @Transactional
    public void setModerator(String username) {
        userDao.setModerator(username);
    }


}
