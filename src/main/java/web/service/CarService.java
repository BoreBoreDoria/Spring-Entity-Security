package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> allCar();
    void add(Car car);
    void delete(Car car);
    void edit(Car car);
    Car getCarById(int id);
}
