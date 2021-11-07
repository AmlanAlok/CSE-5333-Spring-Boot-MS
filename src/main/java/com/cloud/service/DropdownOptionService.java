package com.cloud.service;

import com.cloud.entity.FoodPreference;
import com.cloud.entity.Role;
import com.cloud.repository.FoodPreferenceRepository;
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

            responseData.put("message","success");
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



    public List<FoodPreference> getFoodPreferenceList(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        try {
            logger.info("Retrieving all food preferences from RDS");
            List<FoodPreference> foodPreferenceDropdownList = foodPreferenceRepository.findAll();
            logger.info("Successfully retrieved -> "+foodPreferenceDropdownList.size()+" Roles");
            logger.info(foodPreferenceDropdownList.toString());
            return foodPreferenceDropdownList;
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all Users from RDS",e);
            throw e;
        }
    }

}
