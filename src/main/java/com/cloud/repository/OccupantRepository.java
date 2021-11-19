package com.cloud.repository;

import com.cloud.entity.Occupant;
import com.cloud.modal.OccupantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccupantRepository extends JpaRepository<Occupant, Long>  {

    @Query("SELECT new com.cloud.modal.OccupantInfo(u.id as userId, u.firstName, u.lastName, u.emailId, o.rentMinimum, o.rentMaximum, o.leaseStartDate, o.state, o.country, g.name as gender, fp.name as foodPreference, dl.name as degreeLevel) " +
            "FROM Occupant o " +
            "JOIN User u ON o.usersId = u.id " +
            "JOIN Gender g ON o.genderId = g.id " +
            "JOIN FoodPreference fp ON o.foodPreferenceId = fp.id " +
            "JOIN DegreeLevel dl ON o.degreeLevelId = dl.id " +
            "JOIN Role r ON u.rolesId = r.id " +
            "WHERE r.name = :roleName")
    List<OccupantInfo> getAllOccupantInfo(@Param("roleName") String roleName);
}
