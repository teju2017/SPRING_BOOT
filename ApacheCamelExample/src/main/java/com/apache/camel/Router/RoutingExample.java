package com.apache.camel.Router;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apache.camel.serviceLevel.InfoPopulator;


@Component
public class RoutingExample extends RouteBuilder {
	

    @Autowired
	InfoPopulator populator;

	@Override
	public void configure() throws Exception {
		//timer
		//Transformation
		//log
		from("timer:first-timer")
		.transform().constant("PASSING SOME VALUE")
		.log("${body}")
		.transform().constant(LocalDateTime.now())
		.log("{body}")
		.bean(populator,"getSomeInformationforCamel")
		.to("log:first-timer");

	}

}
