package com.cloud.repository;

import com.cloud.entity.Accommodation;
import com.cloud.modal.LeaseHolderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    @Query("SELECT new com.cloud.modal.LeaseHolderInfo(u.id as userId, u.firstName, u.lastName, u.emailId, a.bedroomCount, a.bathroomCount, a.vacancyCount, a.rentPerOccupant, a.leaseStartDate, a.leaseEndDate, a.moveInDate, a.distanceFromCampus, a.name, a.address, an.name as furnishingStatus) " +
            "FROM Accommodation a " +
            "JOIN User u ON a.usersId = u.id " +
            "JOIN FurnishingStatus an ON a.furnishingStatusId = an.id")
    List<LeaseHolderInfo> getAllLeaseHolderInfo(@Param("roleName") String roleName);
}
