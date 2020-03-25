package com.lvkheen.service;

import com.lvkheen.entity.Location;
import com.lvkheen.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(String username);

    List<Location> getLocations();

    void deleteLocation(int id);

    Location getLocation(int id);

    void saveLocation(Location location);

    void deleteUser(String username);
}
