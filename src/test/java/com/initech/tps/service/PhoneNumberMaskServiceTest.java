package com.initech.tps.service;

import static org.junit.Assert.*;
import com.initech.tps.InitechTpsApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneNumberMaskServiceTest extends InitechTpsApplicationTests {

    @Autowired
    PhoneNumberMaskService phoneNumberMaskService;

    @Test
    public void TestMaskPhoneNumberWithDashes(){
        assertEquals("678-XXX-1212",phoneNumberMaskService.maskPhoneNumberWithDashes("678-221-1212"));
    }

    @Test
    public void TestMaskPhoneNumberWithPeriods(){
        assertEquals("678.XXX.1212",phoneNumberMaskService.maskPhoneNumberWithPeriods("678.221.1212"));
    }

    @Test
    public void TestMaskPhoneNumberWithTenDigits(){
        assertEquals("678XXX1212",phoneNumberMaskService.maskPhoneNumberWithTenDigits("6782211212"));
    }

}
