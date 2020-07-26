package web.DAO;

import web.model.Car;

import java.util.List;

public interface CarDAO {
    List<Car> allCar();
    void add(Car car);
    void delete(Car car);
    void edit(Car car);
    Car getCarById(int id);
}
