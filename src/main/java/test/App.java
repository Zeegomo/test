package test;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

public class App{
	
	private static final String ASCII_ART = "\n" + 
			"\n" + 
			" _            _   \n" + 
			"| |_ ___  ___| |_ \n" + 
			"| __/ _ \\/ __| __|\n" + 
			"| ||  __/\\__ \\ |_ \n" + 
			" \\__\\___||___/\\__|\n" + 
			"                  \n" + 
			"\n" + 
			"";
	
	private static final URI BASE_URI = URI.create("http://localhost:8080/base/");
	public static final String ROOT_PATH = "rest";

	public static void main(String[] args) {
		try {
			System.out.println(ASCII_ART);

	        final ResourceConfig resourceConfig = new ResourceConfig(HelloWorldResource.class);
	        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig, false);
	        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        	@Override
	            public void run() {
	        		server.shutdownNow();
	            }
	        }));
	        server.start();

	        System.out.println(String.format("Application started.\nTry out %s%s\nStop the application using CTRL+C",
	        	BASE_URI, ROOT_PATH));
	        Thread.currentThread().join();
	        } catch (IOException | InterruptedException ex) {
	            Logger.getLogger(App.class.getName()).log(Level.INFO, null, ex);
	        }

	}

}
