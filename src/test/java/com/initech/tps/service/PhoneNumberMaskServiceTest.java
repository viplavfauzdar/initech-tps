package com.initech.tps.service;

import static org.junit.Assert.*;
import com.initech.tps.InitechTpsApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PhoneNumberMaskServiceTest extends InitechTpsApplicationTests {

    @Autowired
    PhoneNumberMaskService phoneNumberMaskService;

    @Test
    public void TestPhoneNumberMask(){
        assertEquals("678-XXX-1212",phoneNumberMaskService.maskPhoneNumberWithDashes("678-221-1212"));
    }

}
