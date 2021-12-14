package com.cloud.repository;

import com.cloud.entity.FurnishingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnishingStatusRepository extends JpaRepository<FurnishingStatus, Long> {
}
