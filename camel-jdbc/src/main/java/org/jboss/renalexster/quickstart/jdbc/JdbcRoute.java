package org.jboss.renalexster.quickstart.jdbc;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class JdbcRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		rest("client").get().produces("application/json").route()
		.enrich("sql://select * from client?dataSource=#datasource")
		.marshal().json(JsonLibrary.Jackson)
		.endRest();
		
		rest("client").post().consumes("application/json").produces("text/plain").route()
		.unmarshal().json(JsonLibrary.Jackson)
		.to("sql://insert into client(id,firstName) values (:#id, :#name)?dataSource=#datasource")
		.transform().constant("OK")
		.endRest();
	}	

}
