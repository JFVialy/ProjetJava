package com.heh.superconcessionnaire2000.adapter.out.ContractAdapter;

import com.heh.superconcessionnaire2000.adapter.out.CarAdapter.CarJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractJpaEntity, Integer>
{
}
