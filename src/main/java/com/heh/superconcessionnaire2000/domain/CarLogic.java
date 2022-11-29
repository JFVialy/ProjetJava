package com.heh.superconcessionnaire2000.domain;

import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.port.in.AddCarUseCase;
import com.heh.superconcessionnaire2000.port.in.CarListUseCase;
import com.heh.superconcessionnaire2000.port.out.GetCars;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CarLogic implements CarListUseCase, AddCarUseCase
{
    private GetCars carGetter;

    public CarLogic(GetCars carGetter) {
        this.carGetter = carGetter;
    }

    @Override
    public List<Car> getCarList()
    {
        return this.carGetter.getAllCars();
    }

    @Override
    public void addCar(Car car)
    {
        this.carGetter.addCarToDB(car);
    }
}
