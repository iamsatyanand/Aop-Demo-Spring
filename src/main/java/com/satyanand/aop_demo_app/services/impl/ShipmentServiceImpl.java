package com.satyanand.aop_demo_app.services.impl;

import com.satyanand.aop_demo_app.services.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {
    @Override
    public String orderPackage(Long orderId) {
        try{
            log.info("Processing the order...");
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            log.error("Error occurred while processing the order", ex);
        }

        return "Order has been processed successfully, orderId: "+orderId;
    }

    @Override
    public String trackPackage(Long orderId) {
        try{
            log.info("Tracking the order...");
            Thread.sleep(500);
            throw new RuntimeException("Exception occurred during trackPackage");
        }catch(InterruptedException ex){
            throw new RuntimeException(ex);
        }
    }
}
