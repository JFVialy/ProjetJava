package com.heh.superconcessionnaire2000.port.out;

import com.heh.superconcessionnaire2000.model.Car;

import java.util.List;

public interface CarManagerOut
{
    List<Car> getAllCars();
    void addCarToDB(Car car);
    Integer getLastCarId();
    Car getCarById(Integer id);
    void deleteCar(Integer id);
    void sellCar(Integer id);
    void updateCar(Car car);
}
