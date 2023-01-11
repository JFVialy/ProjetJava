package com.heh.superconcessionnaire2000.port.in;

import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.model.Contract;
import com.heh.superconcessionnaire2000.model.User;

import java.util.List;

public interface ContractManagerIn
{
    List<Contract> getAllContracts();
    void addContract(Car car, User user);
}
