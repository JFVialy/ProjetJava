package com.heh.superconcessionnaire2000.port.in;

import com.heh.superconcessionnaire2000.model.Car;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CarManagerIn
{
    List<Car> getCarList();
    void addCar(Car car, MultipartFile file) throws IOException;
    Car getCar(Integer id);
    void deleteCar(Integer id);
    void updateCar(Car car);
}
