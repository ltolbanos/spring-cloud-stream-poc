package com.santander.serenity.devstack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ltolbanos on 05/10/2016.
 */
@RestController
@EnableBinding(Source.class)
public class HttpSource {

    @Autowired
    private MessageChannel output;

    @RequestMapping(path = "/messages", method = RequestMethod.POST)
    public void sayHello(@RequestBody String name){
        output.send(MessageBuilder.withPayload("Hello " + name).build());
    }
}
