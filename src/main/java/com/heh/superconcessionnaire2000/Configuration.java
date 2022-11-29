package com.heh.superconcessionnaire2000;


import com.heh.superconcessionnaire2000.adapter.out.CarMapper;
import com.heh.superconcessionnaire2000.adapter.out.CarPersistenceAdapter;
import com.heh.superconcessionnaire2000.adapter.out.CarRepository;
import com.heh.superconcessionnaire2000.domain.CarLogic;
import com.heh.superconcessionnaire2000.port.in.CarListUseCase;
import com.heh.superconcessionnaire2000.port.out.GetCars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories(basePackages = "com.heh.superconcessionnaire2000.adapter.out")
public class Configuration
{
    private CarRepository carRepo;

    private final CarMapper carMap = new CarMapper();
    private final CarPersistenceAdapter carAdapter = new CarPersistenceAdapter(carRepo, carMap);

    @Bean
    CarListUseCase getCarListUseCase()
    {
        return new CarLogic(carAdapter);
    }

    @Bean
    GetCars getGetCars()
    {
        return carAdapter;
    }
}
