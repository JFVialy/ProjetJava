package com.heh.superconcessionnaire2000;


import com.heh.superconcessionnaire2000.adapter.out.CarAdapter.CarMapper;
import com.heh.superconcessionnaire2000.adapter.out.CarAdapter.CarPersistenceAdapter;
import com.heh.superconcessionnaire2000.adapter.out.CarAdapter.CarRepository;
import com.heh.superconcessionnaire2000.adapter.out.ContractAdapter.ContractMapper;
import com.heh.superconcessionnaire2000.adapter.out.ContractAdapter.ContractPersistenceAdapter;
import com.heh.superconcessionnaire2000.adapter.out.ContractAdapter.ContractRepository;
import com.heh.superconcessionnaire2000.adapter.out.UserAdapter;
import com.heh.superconcessionnaire2000.domain.CarLogic;
import com.heh.superconcessionnaire2000.domain.ContractLogic;
import com.heh.superconcessionnaire2000.domain.UserLogic;
import com.heh.superconcessionnaire2000.port.in.CarManagerIn;
import com.heh.superconcessionnaire2000.port.in.ContractManagerIn;
import com.heh.superconcessionnaire2000.port.in.UserManagerIn;
import com.heh.superconcessionnaire2000.port.out.CarManagerOut;
import com.heh.superconcessionnaire2000.port.out.ContractManagerOut;
import com.heh.superconcessionnaire2000.port.out.UserManagerOut;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories(basePackages = "com.heh.superconcessionnaire2000.adapter.out")
public class Configuration
{
    private CarRepository carRepo;
    private final CarMapper carMap = new CarMapper();
    private final CarPersistenceAdapter carAdapter = new CarPersistenceAdapter(carRepo, carMap);
    private final UserAdapter userAdapter = new UserAdapter();

    private ContractRepository contractRepository;
    private final ContractMapper contractMap = new ContractMapper();
    private final ContractPersistenceAdapter contractAdapter = new ContractPersistenceAdapter(contractRepository, contractMap);

    @Bean
    CarManagerIn getCarListUseCase()
    {
        return new CarLogic(carAdapter);
    }

    @Bean
    CarManagerOut getGetCars()
    {
        return carAdapter;
    }

    @Bean
    UserManagerIn getUserManagerIn()
    {
        return new UserLogic(userAdapter);
    }

    @Bean
    UserManagerOut getUserManagerOut()
    {
        return userAdapter;
    }

    @Bean
    ContractManagerIn getContractManagerIn()
    {
        return new ContractLogic(contractAdapter, carAdapter);
    }

    @Bean
    ContractManagerOut getContractManagerOut()
    {
        return contractAdapter;
    }
}
