package com.heh.superconcessionnaire2000.port.out;

import com.heh.superconcessionnaire2000.model.Car;

import java.util.List;

public interface GetCars
{
    List<Car> getAllCars();
    void addCarToDB(Car car);
}
