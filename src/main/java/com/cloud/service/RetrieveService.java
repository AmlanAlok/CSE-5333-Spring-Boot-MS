package com.cloud.service;

import com.cloud.constants.Constants;
import com.cloud.modal.OccupantInfo;
import com.cloud.repository.OccupantRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RetrieveService {

    private static final Logger logger = Logger.getLogger(RetrieveService.class.getName());

    @Autowired
    public OccupantRepository occupantRepository;

    public ResponseEntity<JSONObject> getAllOccupants(){
        logger.info("In "+new Throwable().getStackTrace()[0].getMethodName()
                +" of "+this.getClass().getSimpleName());

        JSONObject responseData = new JSONObject();

        try {
            List<OccupantInfo> occupantList = occupantRepository.getAllOccupantInfo(new Constants().OCCUPANT);
            JSONObject data = new JSONObject();
            data.put("occupantList", occupantList);

            responseData.put("message","success");
            responseData.put("data", data);

            return ResponseEntity.status(HttpStatus.OK).body(responseData);
        }
        catch(Exception e){
            logger.log(Level.SEVERE,"Exception occurred while getting all occupants from RDS", e);
            responseData.put("message","failed");
            responseData.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseData);
        }
    }
}
