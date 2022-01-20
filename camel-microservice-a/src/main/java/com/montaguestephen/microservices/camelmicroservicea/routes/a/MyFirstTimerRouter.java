package com.montaguestephen.microservices.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;

    @Override
    public void configure() throws Exception {
        // use a timer to trigger messages
        // transformation
        // log it to the console

        // Created a timer endpoint below
        from("timer:first-timer")
//                .transform().constant("My constant message")
//                .transform().constant("Time now is " + LocalDateTime.now())
                .bean(getCurrentTimeBean)
                .to("log:first-timer");
    }
}

@Component
class GetCurrentTimeBean {
    public String GetCurrentTime() {
        return "Time now is " + LocalDateTime.now();
    }
}