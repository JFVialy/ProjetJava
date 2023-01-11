package com.heh.superconcessionnaire2000.adapter.out.CarAdapter;

import com.heh.superconcessionnaire2000.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarMapper
{
    public List<Car> mapToDomainEntity(List<CarJpaEntity> cars)
    {
        List<Car> carsList = new ArrayList<>();

        for(CarJpaEntity carJpaEntity: cars)
        {
            carsList.add(new Car(carJpaEntity.getId(),
                    carJpaEntity.getBrand(),
                    carJpaEntity.getModel(),
                    carJpaEntity.getYear(),
                    carJpaEntity.getTrim(),
                    carJpaEntity.getKms(),
                    carJpaEntity.getPrice(),
                    carJpaEntity.getImage(),
                    carJpaEntity.getSold(),
                    carJpaEntity.getDeleted()));

        }
        return carsList;
    }

    public CarJpaEntity mapToJpaEntity(Car car)
    {
        CarJpaEntity carJpaEntity = new CarJpaEntity();
        carJpaEntity.setId(car.getCarId());
        carJpaEntity.setBrand(car.getBrand());
        carJpaEntity.setModel(car.getModel());
        carJpaEntity.setYear(car.getYear());
        carJpaEntity.setTrim(car.getTrim());
        carJpaEntity.setKms(car.getKms());
        carJpaEntity.setPrice(car.getPrice());
        carJpaEntity.setImage(car.getImage());
        carJpaEntity.setSold(car.getSold());
        carJpaEntity.setDeleted(car.getDeleted());

        return carJpaEntity;
    }

    public Car mapFromJpaEntity(Optional<CarJpaEntity> carJpaEntityOptional)
    {
        if(carJpaEntityOptional.isPresent())
        {
            CarJpaEntity carJpaEntity = carJpaEntityOptional.get();
            return new Car(carJpaEntity.getId(),
                    carJpaEntity.getBrand(),
                    carJpaEntity.getModel(),
                    carJpaEntity.getYear(),
                    carJpaEntity.getTrim(),
                    carJpaEntity.getKms(),
                    carJpaEntity.getPrice(),
                    carJpaEntity.getImage(),
                    carJpaEntity.getSold(),
                    carJpaEntity.getDeleted());
        }
        else
        {
            return null;
        }
    }
}
