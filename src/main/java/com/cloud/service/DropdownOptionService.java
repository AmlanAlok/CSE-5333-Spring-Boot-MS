package com.cloud.service;

import com.cloud.entity.Role;
import com.cloud.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class DropdownOptionService {

    private static final Logger logger = Logger.getLogger(DropdownOptionService.class.getName());

    @Autowired
    public RoleRepository roleRepository;

    public List<Role> getRoleDropdownList(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        try {
            logger.info("Retrieving all Roles from RDS");
            List<Role> roleDropdownList = roleRepository.getRoleDropdown();
            logger.info("Successfully retrieved -> "+roleDropdownList.size()+" Roles");
            logger.info(roleDropdownList.toString());
            return roleDropdownList;
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all Users from RDS",e);
            throw e;
        }
    }
}
