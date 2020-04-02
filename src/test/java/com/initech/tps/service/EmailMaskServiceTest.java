package com.initech.tps.service;

import com.initech.tps.InitechTpsApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class EmailMaskServiceTest extends InitechTpsApplicationTests {

    @Autowired
    EmailMaskService emailMaskService;

    @Test
    public void maskEmailTest(){
        assertEquals("vXXXF@gmail.com",emailMaskService.maskEmailId("viplavF@gmail.com"));
    }


}
