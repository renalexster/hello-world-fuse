package org.jboss.renalexster.quickstart.jdbc;

import org.apache.camel.builder.RouteBuilder;

public class RestConfigRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").contextPath("camel-jdbc/api");
		
		rest().get("ping").produces("application/json").route().setBody(constant("Hello World"));

	}

}
