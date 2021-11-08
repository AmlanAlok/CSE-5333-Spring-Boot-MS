package com.cloud.controller;

import com.cloud.modal.OccupantSignUpData;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/signup")
public class SignUpController {

    private static final Logger logger = Logger.getLogger(SignUpController.class.getName());

    @PostMapping(value = "/occupant")
//    public ResponseEntity<JSONObject> getRoleDropdown(){
    public void saveOccupantSignUpData(@RequestBody OccupantSignUpData occupantSignUpData){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());
        logger.info(occupantSignUpData.toString());

//        return dropdownOptionService.getRoleDropdownList();
    }


}
