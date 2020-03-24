package com.lvkheen.dao;

import com.lvkheen.entity.Location;
import com.lvkheen.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User", User.class);
        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User where username=:userName", User.class);
        query.setParameter("userName", username);
        User user = query.getSingleResult();

        return user;
    }

    @Override
    public List<Location> getLocations() {
        Session session = sessionFactory.getCurrentSession();

        Query<Location> query = session.createQuery("from Location order by city", Location.class);
        List<Location> locations = query.getResultList();

        return locations;
    }

    @Override
    public void deleteLocation(int id) {
        Session session = sessionFactory.getCurrentSession();

        Location location = session.get(Location.class, id);
        session.delete(location);
    }

    @Override
    public Location getLocation(int id) {
        Session session = sessionFactory.getCurrentSession();
        Location location = session.get(Location.class, id);

        return location;
    }

    @Override
    public void saveLocation(Location location) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(location);
    }

}
