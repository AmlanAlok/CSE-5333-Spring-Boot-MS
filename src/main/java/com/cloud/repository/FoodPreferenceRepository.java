package com.cloud.repository;

import com.cloud.entity.FoodPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPreferenceRepository extends JpaRepository<FoodPreference, Long>  {
}
