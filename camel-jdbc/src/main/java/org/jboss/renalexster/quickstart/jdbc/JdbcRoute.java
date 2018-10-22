package org.jboss.renalexster.quickstart.jdbc;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class JdbcRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		rest("client").get().produces("application/json").route().enrich("sql://select * from helloworld.client?dataSource=#datasource")
		.marshal().json(JsonLibrary.Jackson)
		.endRest();
	}	

}
