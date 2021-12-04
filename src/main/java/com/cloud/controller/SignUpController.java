package com.cloud.controller;

import com.cloud.modal.LeaseHolderSignUpData;
import com.cloud.modal.OccupantSignUpData;
import com.cloud.service.SignUpService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://34.127.76.90:3000",
        "http://localhost:3001", "http://34.127.76.90:3001",
        "http://localhost:3002", "http://34.127.76.90:3002"})
@RequestMapping("/signup")
public class SignUpController {

    private static final Logger logger = Logger.getLogger(SignUpController.class.getName());

    @Autowired
    public SignUpService signUpService;

    @PostMapping(value = "/occupant")
    public ResponseEntity<JSONObject> saveOccupantSignUpData(@RequestBody OccupantSignUpData occupantSignUpData){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        logger.info(occupantSignUpData.toString());

        return signUpService.singUpOccupant(occupantSignUpData);
    }

    @PostMapping(value = "/leaseHolder")
    public ResponseEntity<JSONObject> saveLeaseHolderSignUpData(@RequestBody LeaseHolderSignUpData leaseHolderSignUpData){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        logger.info(leaseHolderSignUpData.toString());

        return signUpService.singUpLeaseHolder(leaseHolderSignUpData);
    }


}
