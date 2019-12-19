package com.home;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.home.controller.HomeController;



/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
    @Test
    public void testApp()
    {
        HomeController hm = new HomeController();
        ResponseEntity<String> result = hm.sayHello();
        assertEquals(result.getBody(),"Spring Boot Hello World");
    }
}
