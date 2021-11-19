package com.cloud.repository;

import com.cloud.entity.AccommodationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationNameRepository extends JpaRepository<AccommodationName, Long> {
}
