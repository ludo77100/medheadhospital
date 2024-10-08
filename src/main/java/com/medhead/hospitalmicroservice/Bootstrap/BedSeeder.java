/*
package com.medhead.hospitalmicroservice.Bootstrap;


import com.medhead.hospitalmicroservice.routing.Routing;
import com.medhead.hospitalmicroservice.services.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class BedSeeder implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    BedService bedService ;

    @Autowired
    Routing routing ;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //this.createBulkBed();
        //routing.routingCalcul();
    }

    private void createBulkBed() {

        for (long i = 1 ; i <= 11 ; i++){
            for (long j = 22 ; j <= 83 ; j++){
                if (i % 2 != 0 && j % 2 == 0){
                    bedService.bulkSave(i, j, 1);
                    System.out.println(i + "   " + j);
                }
            }
        }
    }
}
*/
