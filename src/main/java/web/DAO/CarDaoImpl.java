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
        TypedQuery<Car> query=session.createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public void add(Car car) {
    }

    @Override
    public void delete(Car car) {
    }

    @Override
    public void edit(Car car) {
    }

    @Override
    public Car getCarById(int id) {
        return null;
    }
}
