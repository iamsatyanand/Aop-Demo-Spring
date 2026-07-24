package com.satyanand.aop_demo_app.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShipmentServiceImplTest {

    @Autowired
    private ShipmentServiceImpl service;

    @Test
    void aopTestOrderPackage(){
        String orderString = service.orderPackage(4L);
        log.info(orderString);
    }

    @Test
    void aopTestTrackPackage() {
        service.trackPackage(4L);
    }
}
