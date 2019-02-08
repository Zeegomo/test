package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("test")
public class HelloWorldResource {
	
	@GET
	@Path("hs")
	@Produces("text/plain")
	public String getGreetings(){
		return "ciao";
	}
}
