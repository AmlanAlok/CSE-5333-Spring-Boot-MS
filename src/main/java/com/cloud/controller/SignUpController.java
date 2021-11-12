package com.cloud.controller;

import com.cloud.modal.OccupantSignUpData;
import com.cloud.service.SignUpService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
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


}
