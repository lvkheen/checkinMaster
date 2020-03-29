package com.lvkheen.dao;

import com.lvkheen.entity.Authorities;
import com.lvkheen.entity.CrmUser;
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

        User user = session.get(User.class, username);

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

    @Override
    public void deleteUser(String userToDelete) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from User where username=:userToDelete");
        query.setParameter("userToDelete", userToDelete);
        query.executeUpdate();
    }

    @Override
    public void saveUser(CrmUser crmUser) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println(">>>>>saving");


        User user = new User();
        Authorities role_user = new Authorities("ROLE_USER");

        user.setUsername(crmUser.getUsername());
        user.setPassword("{noop}" + crmUser.getPassword());
        user.setEnabled(1);
        user.add(role_user);

        session.save(user);
        session.save(role_user);

    }

    @Override
    public void banUser(String username) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, username);
        Authorities role_suspended = new Authorities("ROLE_SUSPENDED");

        Query query = session.createQuery("delete from Authorities where username=:userToBan");
        query.setParameter("userToBan", username);
        query.executeUpdate();

        user.add(role_suspended);

        session.save(user);
        session.save(role_suspended);
    }

    @Override
    public void restoreUser(String username) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, username);
        Authorities role_user = new Authorities("ROLE_USER");

        Query query = session.createQuery("delete from Authorities where username=:userToRestore");
        query.setParameter("userToRestore", username);
        query.executeUpdate();

        user.add(role_user);

        session.save(user);
        session.save(role_user);
    }

    @Override
    public void setAdmin(String username) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, username);
        Authorities role_user = new Authorities("ROLE_USER");
        Authorities role_admin = new Authorities("ROLE_ADMIN");

        Query query = session.createQuery("delete from Authorities where username=:userToSetAdmin");
        query.setParameter("userToSetAdmin", username);
        query.executeUpdate();

        user.add(role_user);
        user.add(role_admin);

        session.save(user);
        session.save(role_user);
        session.save(role_admin);
    }

    @Override
    public void setModerator(String username) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, username);
        Authorities role_user = new Authorities("ROLE_USER");
        Authorities role_moderator = new Authorities("ROLE_MODERATOR");

        Query query = session.createQuery("delete from Authorities where username=:userToSetModerator");
        query.setParameter("userToSetModerator", username);
        query.executeUpdate();

        user.add(role_user);
        user.add(role_moderator);

        session.save(user);
        session.save(role_user);
        session.save(role_moderator);
    }

}
