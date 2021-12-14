package com.cloud.controller;

import com.cloud.entity.Role;
import com.cloud.service.RoleService;
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
@CrossOrigin(origins = {"http://localhost:3000", "http://34.127.76.90:3000",
        "http://localhost:3001", "http://34.127.76.90:3001",
        "http://localhost:3002", "http://34.127.76.90:3002", "http://35.230.62.145:3000", "*"})
@RequestMapping("/platform/user")
public class RoleController {

    private static final Logger logger = Logger.getLogger(RoleController.class.getName());

    @Autowired
    public RoleService roleService;

    @GetMapping("/getRoleData")
    public ResponseEntity<List<Role>> getRoleData(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        return ResponseEntity.status(HttpStatus.OK).body(roleService.getAllRoleData());
    }
}
