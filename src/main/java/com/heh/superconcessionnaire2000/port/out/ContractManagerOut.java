package com.heh.superconcessionnaire2000.port.out;

import com.heh.superconcessionnaire2000.model.Contract;
import java.util.List;

public interface ContractManagerOut
{
    public List<Contract> getAllContracts();
    void addContractToDB(Contract contract);
}
