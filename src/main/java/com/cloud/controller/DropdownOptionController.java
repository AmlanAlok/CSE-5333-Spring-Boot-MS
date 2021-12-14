package com.cloud.controller;


import com.cloud.service.DropdownOptionService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://34.127.76.90:3000",
        "http://localhost:3001", "http://34.127.76.90:3001",
        "http://localhost:3002", "http://34.127.76.90:3002", "http://35.230.62.145:3000", "*"})
@RequestMapping("/dropdown")
public class DropdownOptionController {

    private static final Logger logger = Logger.getLogger(DropdownOptionController.class.getName());

    @Autowired
    DropdownOptionService dropdownOptionService;

    @GetMapping(value = "/get/roles")
    public ResponseEntity<JSONObject> getRoleDropdown(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        return dropdownOptionService.getRoleDropdownList();
    }

    @GetMapping(value = "/get/occupant/signup-options")
    public ResponseEntity<JSONObject> getOccupantSignUpDropdown(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        return dropdownOptionService.getOccupantSignUpDropdowns();
    }

    @GetMapping(value = "/get/leaseHolder/signup-options")
    public ResponseEntity<JSONObject> getLeaseHolderSignUpDropdown(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        return dropdownOptionService.getLeaseHolderSignUpDropdowns();
    }

}
