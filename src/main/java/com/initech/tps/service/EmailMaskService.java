package com.initech.tps.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service for masking email by replacing the handle with XXX except the first and last character
 * e.g. viplavf@gmail.com masked to vXXXf@gmail.com
 * */

@Service
@Slf4j
public class EmailMaskService {

    /**
     * Service method to mask email
     * @param - Email ID
     * @return - Masked email ID
     * */
    public String maskEmailId(String emailId){
        //remove any leading or trailing spaces
        emailId = emailId.trim();
        String[] emailIdSplit = emailId.split("@");
        emailId =  String.format("%sXXX%s@%s", emailIdSplit[0].substring(0,1),emailIdSplit[0].substring(emailIdSplit[0].length()-1), emailIdSplit[1]);
        log.info("Masked Email: {}", emailId);
        return emailId;
    }
}
