package com.heh.superconcessionnaire2000.domain;

import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.model.Contract;
import com.heh.superconcessionnaire2000.model.User;
import com.heh.superconcessionnaire2000.port.in.ContractManagerIn;
import com.heh.superconcessionnaire2000.port.out.CarManagerOut;
import com.heh.superconcessionnaire2000.port.out.ContractManagerOut;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ContractLogic implements ContractManagerIn
{
    private ContractManagerOut contractManagerOut;
    private CarManagerOut carManagerOut;

    public ContractLogic(ContractManagerOut contractManagerOut, CarManagerOut carManagerOut)
    {
        this.contractManagerOut = contractManagerOut;
        this.carManagerOut = carManagerOut;
    }

    @Override
    public List<Contract> getAllContracts()
    {
        return contractManagerOut.getAllContracts();
    }

    @Override
    public void addContract(Car car, User user)
    {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Contract contract = new Contract(
                null,
                car.getCarId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                timestamp,
                car.carToString());
        carManagerOut.sellCar(car.getCarId());
        contractManagerOut.addContractToDB(contract);
    }
}
