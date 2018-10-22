package org.jboss.renalexster.quickstart.rest;

import org.apache.camel.builder.RouteBuilder;

public class RestConfigRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").contextPath("hello/api");
		
		rest().get("ping").produces("application/json").route().setBody(constant("Hello World"));

	}

}
