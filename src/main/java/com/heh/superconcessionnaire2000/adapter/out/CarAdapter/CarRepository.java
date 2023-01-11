package com.heh.superconcessionnaire2000.adapter.out.CarAdapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarJpaEntity, Integer>
{
    CarJpaEntity findTopByOrderByIdDesc();
}
