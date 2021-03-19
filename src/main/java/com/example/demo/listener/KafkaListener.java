package com.example.demo.listener;

import com.example.demo.model.Person;
import com.example.demo.service.ProducerService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KafkaListener {

    @Inject
    ProducerService producer;

    @POST
    public Response send(Person person) {
        producer.sendPersonToKafka(person);
        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }
}