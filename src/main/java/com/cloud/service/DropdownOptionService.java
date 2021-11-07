package com.cloud.service;

import com.cloud.entity.DegreeLevel;
import com.cloud.entity.FoodPreference;
import com.cloud.entity.Gender;
import com.cloud.entity.Role;
import com.cloud.repository.DegreeLevelRepository;
import com.cloud.repository.FoodPreferenceRepository;
import com.cloud.repository.GenderRepository;
import com.cloud.repository.RoleRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class DropdownOptionService {

    private static final Logger logger = Logger.getLogger(DropdownOptionService.class.getName());

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public FoodPreferenceRepository foodPreferenceRepository;

    @Autowired
    public GenderRepository genderRepository;

    @Autowired
    public DegreeLevelRepository degreeLevelRepository;

    public ResponseEntity<JSONObject> getRoleDropdownList(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        JSONObject responseData = new JSONObject();

        try {
            logger.info("Retrieving all Roles from RDS");
            List<Role> roleDropdownList = roleRepository.getRoleDropdown();
            logger.info("Successfully retrieved -> "+roleDropdownList.size()+" Roles");
            logger.info(roleDropdownList.toString());

            JSONObject roleDropdown = new JSONObject();
            roleDropdown.put("roleDropdownList", roleDropdownList);

            responseData.put("message","success");
            responseData.put("data", roleDropdown);

            return ResponseEntity.status(HttpStatus.OK).body(responseData);
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all Roles from RDS", e);
            responseData.put("message","failed");
            responseData.put("error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    public ResponseEntity<JSONObject> getOccupantSignUpDropdowns(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        JSONObject responseData = new JSONObject();

        try {
            JSONObject dropdownOptions = new JSONObject();
            dropdownOptions.put("foodPreferenceDropdownList", this.getFoodPreferenceList());
            dropdownOptions.put("genderDropdownList", this.getGenderList());
            dropdownOptions.put("degreeLevelsDropdownList", this.getDegreeLevelList());
            responseData.put("message","success");
            responseData.put("data", dropdownOptions);

            return ResponseEntity.status(HttpStatus.OK).body(responseData);
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all Roles from RDS", e);
            responseData.put("message","failed");
            responseData.put("error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }

    public List<DegreeLevel> getDegreeLevelList() {
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        try {
            logger.info("Retrieving all degree levels from RDS");
            List<DegreeLevel> degreeLevelDropdownList = degreeLevelRepository.findAll();
            logger.info("Successfully retrieved -> "+degreeLevelDropdownList.size()+" degree levels");
            logger.info(degreeLevelDropdownList.toString());
            return degreeLevelDropdownList;
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all degree levels from RDS",e);
            throw e;
        }
    }

    public List<Gender> getGenderList() {
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        try {
            logger.info("Retrieving all genders from RDS");
            List<Gender> genderDropdownList = genderRepository.findAll();
            logger.info("Successfully retrieved -> "+genderDropdownList.size()+" genders");
            logger.info(genderDropdownList.toString());
            return genderDropdownList;
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all genders from RDS",e);
            throw e;
        }
    }

    public List<FoodPreference> getFoodPreferenceList(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        try {
            logger.info("Retrieving all food preferences from RDS");
            List<FoodPreference> foodPreferenceDropdownList = foodPreferenceRepository.findAll();
            logger.info("Successfully retrieved -> "+foodPreferenceDropdownList.size()+" food preferences");
            logger.info(foodPreferenceDropdownList.toString());
            return foodPreferenceDropdownList;
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all food preferences from RDS",e);
            throw e;
        }
    }

}
