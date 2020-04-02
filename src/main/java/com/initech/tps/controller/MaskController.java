package com.initech.tps.controller;

import com.initech.tps.service.EmailMaskService;
import com.initech.tps.service.PhoneNumberMaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MaskController {

    @Autowired
    PhoneNumberMaskService phoneNumberMaskService;

    @Autowired
    EmailMaskService emailMaskService;


    @GetMapping("/maskphonenumber/{phonenumber}")
    public String maskPhoneNumber(@PathVariable String phonenumber){
        if(phonenumber.contains("-"))
            return phoneNumberMaskService.maskPhoneNumberWithDashes(phonenumber);
        else if(phonenumber.contains("."))
            return phoneNumberMaskService.maskPhoneNumberWithPeriods(phonenumber);
        else
            return phoneNumberMaskService.maskPhoneNumberWithTenDigits(phonenumber);
    }

    @GetMapping("/maskemailid/{emailid}")
    public String maskEmailId(@PathVariable String emailid){
        return emailMaskService.maskEmailId(emailid);
    }
}
