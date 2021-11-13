package com.cloud.service;

import com.cloud.entity.Accommodation;
import com.cloud.entity.Occupant;
import com.cloud.entity.User;
import com.cloud.modal.LeaseHolderSignUpData;
import com.cloud.modal.OccupantSignUpData;
import com.cloud.repository.AccommodationRepository;
import com.cloud.repository.OccupantRepository;
import com.cloud.repository.UserRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class SignUpService {

    private static final Logger logger = Logger.getLogger(SignUpService.class.getName());

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public AccommodationRepository accommodationRepository;

    @Autowired
    public OccupantRepository occupantRepository;

    public ResponseEntity<JSONObject> singUpLeaseHolder(LeaseHolderSignUpData leaseHolderSignUpData){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        JSONObject responseData = new JSONObject();

        User user = new User(leaseHolderSignUpData.getFirstName(),
                leaseHolderSignUpData.getLastName(),
                leaseHolderSignUpData.getEmailId(),
                leaseHolderSignUpData.getPassword(),
                leaseHolderSignUpData.getPhoneNumber(),
                1,          // 1 means active, 0 means inactive
                leaseHolderSignUpData.getRolesId(),
                new Timestamp(System.currentTimeMillis())
        );

        Accommodation accommodation = new Accommodation(leaseHolderSignUpData.getBedroomCount(),
                leaseHolderSignUpData.getBathroomCount(),
                leaseHolderSignUpData.getVacancyCount(),
                leaseHolderSignUpData.getRentPerOccupant(),
                leaseHolderSignUpData.getLeaseStartDate(),
                leaseHolderSignUpData.getLeaseEndDate(),
                leaseHolderSignUpData.getMoveInDate(),
                leaseHolderSignUpData.getDistanceFromCampus(),
                leaseHolderSignUpData.getName(),
                leaseHolderSignUpData.getAddress(),
                leaseHolderSignUpData.getFurnishingStatusId(),
                new Timestamp(System.currentTimeMillis())
                );

        try {
            logger.info("Saving Lease Holder user data in RDS");

            User userRecord = userRepository.save(user);
            logger.info(userRecord.toString());

            accommodation.setUsersId(userRecord.getId());

            Accommodation accommodationRecord = accommodationRepository.save(accommodation);
            logger.info(accommodationRecord.toString());

            logger.info("Successfully saved Lease Holder with userId = "+userRecord.getId());

            JSONObject userIdObj = new JSONObject();
            userIdObj.put("userId", userRecord.getId());

            responseData.put("message","success");
            responseData.put("data", userIdObj);

            return ResponseEntity.status(HttpStatus.OK).body(responseData);
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while saving occupants to RDS", e);
            responseData.put("message","failed");
            responseData.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    public ResponseEntity<JSONObject> singUpOccupant(OccupantSignUpData occupantSignUpData){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        JSONObject responseData = new JSONObject();

        User user = new User(occupantSignUpData.getFirstName(),
                occupantSignUpData.getLastName(),
                occupantSignUpData.getEmailId(),
                occupantSignUpData.getPassword(),
                occupantSignUpData.getPhoneNumber(),
                1,          // 1 means active, 0 means inactive
                occupantSignUpData.getRolesId(),
                new Timestamp(System.currentTimeMillis())
        );

        logger.info(user.toString());

        Occupant occupant = new Occupant(occupantSignUpData.getRentMinimum(),
                occupantSignUpData.getRentMaximum(),
                Date.valueOf(occupantSignUpData.getLeaseStartDate()),
                occupantSignUpData.getState(),
                occupantSignUpData.getCountry(),
                occupantSignUpData.getGenderId(),
                occupantSignUpData.getFoodPreferenceId(),
                occupantSignUpData.getDegreeLevelId(),
                new Timestamp(System.currentTimeMillis())
        );

        try {
            logger.info("Saving Occupant user data in RDS");

            User userRecord = userRepository.save(user);
            logger.info(userRecord.toString());

            occupant.setUsersId(userRecord.getId());

            Occupant occupantRecord = occupantRepository.save(occupant);
            logger.info(occupantRecord.toString());

            logger.info("Successfully saved occupant with userId = "+userRecord.getId());

            JSONObject userIdObj = new JSONObject();
            userIdObj.put("userId", userRecord.getId());

            responseData.put("message","success");
            responseData.put("data", userIdObj);

            return ResponseEntity.status(HttpStatus.OK).body(responseData);
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while saving occupants to RDS", e);
            responseData.put("message","failed");
            responseData.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }
}
