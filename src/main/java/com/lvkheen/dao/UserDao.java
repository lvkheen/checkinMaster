package com.lvkheen.dao;

import com.lvkheen.entity.CrmUser;
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

    void saveUser(CrmUser crmUser);

    void banUser(String username);

    void restoreUser(String username);

    void setAdmin(String username);

    void setModerator(String username);
}
