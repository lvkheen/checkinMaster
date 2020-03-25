package com.lvkheen.dao;

import com.lvkheen.entity.Location;
import com.lvkheen.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUser(String user);

    List<Location> getLocations();

    void deleteLocation(int id);

    Location getLocation(int id);

    void saveLocation(Location location);

    void deleteUser(String username);
}
