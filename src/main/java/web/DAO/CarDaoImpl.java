package web.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class CarDaoImpl implements CarDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> allCar() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Car").list();
    }

    @Override
    public void add(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(car);
    }

    @Override
    public void delete(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(car);
    }

    @Override
    public void edit(Car car) {
        Session session = sessionFactory.getCurrentSession();
        session.update(car);
    }

    @Override
    public Car getCarById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }
}
