package com.example.log4j_demo;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LogManager.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {
        try {
        ThreadContext.put("userId", "myuserId");
        ThreadContext.put("requestId", "sdf");
        logger.info("Hello endpoint was called");
        return "Hello, World!";
        } finally {
            ThreadContext.clearAll();
        }
    }
}
