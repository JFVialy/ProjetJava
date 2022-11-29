package com.heh.superconcessionnaire2000.adapter.out;

import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.port.out.GetCars;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

import java.util.List;

@RequiredArgsConstructor
public class CarPersistenceAdapter implements GetCars
{
    @Autowired
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public List<Car> getAllCars()
    {
        List<CarJpaEntity> carEntities = carRepository.findAll();
        return carMapper.mapToDomainEntity(carEntities);
    }

    @Override
    public void addCarToDB(Car car)
    {
        System.out.println(car.getBrand());
        carRepository.save(carMapper.mapToJpaEntity(car));
    }
}
