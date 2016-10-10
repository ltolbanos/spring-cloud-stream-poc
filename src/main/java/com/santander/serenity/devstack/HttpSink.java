package com.santander.serenity.devstack;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by ltolbanos on 06/10/2016.
 */
@EnableBinding(Sink.class)
public class HttpSink {

    @StreamListener(Sink.INPUT)
    public void receiveHello(String message){
        System.out.println(message);
    }


}
