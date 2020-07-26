package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.CarDAO;
import web.DAO.CarDaoImpl;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements  CarService{
    private CarDAO carDao = new CarDaoImpl();

    @Override
    @Transactional
    public List<Car> allCar() {
        return carDao.allCar();
    }

    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    public void delete(Car car) {
        carDao.delete(car);
    }

    @Override
    public void edit(Car car) {
        carDao.edit(car);
    }

    @Override
    public Car getCarById(int id) {
        return carDao.getCarById(id);
    }
}
