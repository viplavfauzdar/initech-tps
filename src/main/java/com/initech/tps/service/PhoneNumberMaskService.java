package com.initech.tps.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service for masking phone numbers by replacing the middle three digits with XXX
 * e.g. 678-221-1212 returns 678-XXX-1212
 *      678.221.1212 returns 678.XXX.1212
 *      6782211212 returns 678XXX1212
 * */

@Service
@Slf4j
public class PhoneNumberMaskService {

    /**
     * Service method to mask phone number containing dashes
     * @param - Phone Number with dashes
     * @return - Masked phone number e.g. 678-XXX-1212
     * */
    public String maskPhoneNumberWithDashes(String phoneNumber){
        //remove any leading or trailing spaces
        phoneNumber = phoneNumber.trim();
        String[] phoneNumberSplit = phoneNumber.split("-");
        phoneNumber =  String.format("%s-XXX-%s", phoneNumberSplit[0], phoneNumberSplit[2]);
        log.info("Masked Phone Number: {}", phoneNumber);
        return phoneNumber;
    }

    /**
     * Service method to mask phone number containing periods
     * @param - Phone Number with dashes
     * @return - Masked phone number e.g. 678.XXX.1212
     * */
    public String maskPhoneNumberWithPeriods(String phoneNumber){
        //remove any leading or trailing spaces
        phoneNumber = phoneNumber.trim();
        String[] phoneNumberSplit = phoneNumber.split("\\.");
        phoneNumber =  String.format("%s.XXX.%s", phoneNumberSplit[0], phoneNumberSplit[2]);
        log.info("Masked Phone Number: {}", phoneNumber);
        return phoneNumber;
    }

    /**
     * Service method to mask phone number containing periods
     * @param - Phone Number with dashes
     * @return - Masked phone number e.g. 678.XXX.1212
     * */
    public String maskPhoneNumberWithTenDigits(String phoneNumber){
        //remove any leading or trailing spaces
        phoneNumber = phoneNumber.trim();
        phoneNumber =  String.format("%sXXX%s", phoneNumber.substring(0,3), phoneNumber.substring(6));
        log.info("Masked Phone Number: {}", phoneNumber);
        return phoneNumber;
    }
}
