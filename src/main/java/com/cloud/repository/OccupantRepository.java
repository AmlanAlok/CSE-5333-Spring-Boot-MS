package com.cloud.repository;

import com.cloud.entity.Occupant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupantRepository extends JpaRepository<Occupant, Long>  {
}
