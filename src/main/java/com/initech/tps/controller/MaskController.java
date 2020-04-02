package com.initech.tps.controller;

import com.initech.tps.service.EmailMaskService;
import com.initech.tps.service.PhoneNumberMaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MaskController class to mask email and phone numbers
 * */

@RestController
@RequestMapping("/api")
public class MaskController {

    @Autowired
    PhoneNumberMaskService phoneNumberMaskService;

    @Autowired
    EmailMaskService emailMaskService;

    /**
     * REST Service for masking phone numbers by replacing the middle three digits with XXX
     * e.g. 678-221-1212 returns 678-XXX-1212
     *      678.221.1212 returns 678.XXX.1212
     *      6782211212 returns 678XXX1212
     * */
    @GetMapping("/maskphonenumber/{phonenumber}")
    public String maskPhoneNumber(@PathVariable String phonenumber){
        if(phonenumber.contains("-"))
            return phoneNumberMaskService.maskPhoneNumberWithDashes(phonenumber);
        else if(phonenumber.contains("."))
            return phoneNumberMaskService.maskPhoneNumberWithPeriods(phonenumber);
        else
            return phoneNumberMaskService.maskPhoneNumberWithTenDigits(phonenumber);
    }

    /**
     * REST Service method to mask email
     * e.g. viplavF@gmail.com returns vXXXF@gmail.com
     * @param - Email ID
     * @return - Masked email ID
     * */
    @GetMapping("/maskemailid/{emailid}")
    public String maskEmailId(@PathVariable String emailid){
        return emailMaskService.maskEmailId(emailid);
    }
}
