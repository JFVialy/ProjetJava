package com.heh.superconcessionnaire2000.adapter.out;

import com.heh.superconcessionnaire2000.model.Car;

import java.util.ArrayList;
import java.util.List;

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
                    carJpaEntity.getPrice()));

        }
        return carsList;
    }
}
