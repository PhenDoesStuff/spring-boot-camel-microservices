package com.montaguestephen.microservices.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // use a timer to trigger messages
        // transformation
        // log it to the console

        // Created a timer endpoint below
        from("timer:first-timer")
                .transform().constant("My constant message")
                .to("log:first-timer");
    }
}
