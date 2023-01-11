package com.heh.superconcessionnaire2000.adapter.out.ContractAdapter;

import com.heh.superconcessionnaire2000.adapter.out.CarAdapter.CarJpaEntity;
import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.model.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractMapper
{
    public List<Contract> mapToDomainEntityList(List<ContractJpaEntity> contracts)
    {
        List<Contract> contractList = new ArrayList<>();

        for(ContractJpaEntity contractJpaEntity : contracts)
        {
            contractList.add(new Contract(contractJpaEntity.getContractid(),
                    contractJpaEntity.getCarid(),
                    contractJpaEntity.getUsername(),
                    contractJpaEntity.getFirstname(),
                    contractJpaEntity.getLastname(),
                    contractJpaEntity.getDate(),
                    contractJpaEntity.getCarstring()));
        }
        return contractList;
    }

    public ContractJpaEntity mapToJpaEntity(Contract contract)
    {
        ContractJpaEntity contractJpaEntity = new ContractJpaEntity();
        contractJpaEntity.setCarid(contract.getCarId());
        contractJpaEntity.setUsername(contract.getUsername());
        contractJpaEntity.setFirstname(contract.getFirstname());
        contractJpaEntity.setLastname(contract.getLastname());
        contractJpaEntity.setDate(contract.getDate());
        contractJpaEntity.setCarstring(contract.getCarString());
        return contractJpaEntity;
    }
}
