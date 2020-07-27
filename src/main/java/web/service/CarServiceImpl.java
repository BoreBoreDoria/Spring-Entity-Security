package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.CarDAO;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements  CarService{

    @Autowired
    private CarDAO carDao;

    @Override
    @Transactional
    public List<Car> allCar() {
        return carDao.allCar();
    }

    @Override
    @Transactional
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    @Transactional
    public void delete(Car car) {
        carDao.delete(car);
    }

    @Override
    @Transactional
    public void edit(Car car) {
        carDao.edit(car);
    }

    @Override
    @Transactional
    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }
}
