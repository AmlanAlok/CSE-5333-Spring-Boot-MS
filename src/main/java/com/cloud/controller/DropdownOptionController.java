package com.cloud.controller;

import com.cloud.entity.Role;
import com.cloud.service.DropdownOptionService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dropdown")
public class DropdownOptionController {

    private static final Logger logger = Logger.getLogger(DropdownOptionController.class.getName());

    @Autowired
    DropdownOptionService dropdownOptionService;

    @GetMapping(value = "/getRoleDropdown")
    public ResponseEntity<JSONObject> getRoleDropdown(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        List<Role> outputData = dropdownOptionService.getRoleDropdownList();

        JSONObject responseData = new JSONObject();
        responseData.put("message","success");
        responseData.put("data", outputData);

        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
