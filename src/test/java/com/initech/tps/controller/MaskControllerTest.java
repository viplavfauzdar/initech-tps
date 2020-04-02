package com.initech.tps.controller;

import com.initech.tps.InitechTpsApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.Assert.*;

public class MaskControllerTest extends InitechTpsApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    MaskController maskController;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void maskEmailTest(){
        String maskedEmail = this.testRestTemplate.getForObject("http://localhost:"+ port + "/api/maskemailid/viplavF@gmail.com", String.class);
        assertEquals("vXXXF@gmail.com", maskedEmail);
    }

    @Test
    public void maskPhoneNumberWithDashesTest(){
        String maskedPhoneNumber = testRestTemplate.getForObject("http://localhost:"+ port + "/api/maskphonenumber/678-221-1212", String.class);
        assertEquals("678-XXX-1212", maskedPhoneNumber);
    }

    @Test
    public void maskPhoneNumberWithPeriodsTest(){
        String maskedPhoneNumber = testRestTemplate.getForObject("http://localhost:"+ port + "/api/maskphonenumber/678.221.1212", String.class);
        assertEquals("678.XXX.1212", maskedPhoneNumber);
    }

    @Test
    public void maskPhoneNumberWithTenDigitsTest(){
        String maskedPhoneNumber = testRestTemplate.getForObject("http://localhost:"+ port + "/api/maskphonenumber/6782211212", String.class);
        assertEquals("678XXX1212", maskedPhoneNumber);
    }
}
