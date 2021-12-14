package com.cloud.repository;

import com.cloud.entity.DegreeLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeLevelRepository extends JpaRepository<DegreeLevel, Long> {
}
