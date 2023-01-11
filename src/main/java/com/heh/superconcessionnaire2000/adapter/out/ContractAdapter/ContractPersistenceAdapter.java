package com.heh.superconcessionnaire2000.adapter.out.ContractAdapter;

import com.heh.superconcessionnaire2000.model.Contract;
import com.heh.superconcessionnaire2000.port.out.CarManagerOut;
import com.heh.superconcessionnaire2000.port.out.ContractManagerOut;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class ContractPersistenceAdapter implements ContractManagerOut
{
    @Autowired
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    @Override
    public List<Contract> getAllContracts()
    {
        List<ContractJpaEntity> contractJpaEntities = contractRepository.findAll();
        return contractMapper.mapToDomainEntityList(contractJpaEntities);
    }

    @Override
    public void addContractToDB(Contract contract)
    {
        contractRepository.save(contractMapper.mapToJpaEntity(contract));
    }
}
