package com.heh.superconcessionnaire2000.adapter.out.CarAdapter;

import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.port.out.CarManagerOut;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CarPersistenceAdapter implements CarManagerOut
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
        carRepository.save(carMapper.mapToJpaEntity(car));
    }

    @Override
    public Integer getLastCarId()
    {
        if(carRepository.findTopByOrderByIdDesc() != null)
        {
            return carRepository.findTopByOrderByIdDesc().getId();
        }
        else
        {
            return 1;
        }
    }

    @Override
    public Car getCarById(Integer id)
    {
        return carMapper.mapFromJpaEntity(carRepository.findById(id));
    }

    @Override
    public void deleteCar(Integer id)
    {
        Optional<CarJpaEntity> carOptionalEntity = carRepository.findById(id);
        CarJpaEntity carJpaEntity = carOptionalEntity.get();
        carJpaEntity.setDeleted(true);
        carRepository.save(carJpaEntity);
    }

    @Override
    public void sellCar(Integer id)
    {
        Optional<CarJpaEntity> carOptionalEntity = carRepository.findById(id);
        CarJpaEntity carJpaEntity = carOptionalEntity.get();
        carJpaEntity.setSold(true);
        carRepository.save(carJpaEntity);
    }

    @Override
    public void updateCar(Car car)
    {
        Optional<CarJpaEntity> carOptionalEntity = carRepository.findById(car.getCarId());
        CarJpaEntity carJpaEntity = carOptionalEntity.get();
        carJpaEntity = carMapper.mapToJpaEntity(car);
        carRepository.save(carJpaEntity);
    }
}
