package com.example.demo.service;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConsumerService {

    private final Logger logger = Logger.getLogger(ConsumerService.class);

    @Incoming("people-in")
    public void receive(Record<String, String> record) {
        logger.infof("Got a person: %s - %s", record.key(), record.value());
    }
}