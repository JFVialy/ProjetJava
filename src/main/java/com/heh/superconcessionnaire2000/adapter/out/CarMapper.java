package com.heh.superconcessionnaire2000.adapter.out;

import com.heh.superconcessionnaire2000.model.Car;
import org.hibernate.loader.custom.ScalarResultColumnProcessor;
import org.springframework.boot.json.JacksonJsonParser;

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

    public CarJpaEntity mapToJpaEntity(Car car)
    {
        CarJpaEntity carJpaEntity = new CarJpaEntity();
        carJpaEntity.setBrand(car.getBrand());
        carJpaEntity.setModel(car.getModel());
        carJpaEntity.setYear(car.getYear());
        carJpaEntity.setTrim(car.getTrim());
        carJpaEntity.setKms(car.getKms());
        carJpaEntity.setPrice(car.getPrice());

        return carJpaEntity;
    }
}
