package com.cloud.service;

import com.cloud.entity.Role;
import com.cloud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

@Service
public class RoleService {

    private static final Logger logger = Logger.getLogger(RoleService.class.getName());


    @Autowired
    public RoleRepository roleRepository;

    public List<Role> getAllRoleData(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        try{
            logger.info("Retrieving all Login records from RDS");
            List<Role> allLoginRecords = roleRepository.findAll();
            logger.info("Successfully retrieved -> "+allLoginRecords.size()+" Roles");
            logger.info(allLoginRecords.toString());
            return allLoginRecords;
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all Users from RDS",e);
            throw e;
        }
    }
}
