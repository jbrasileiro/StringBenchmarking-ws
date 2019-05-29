package stringbenchmarking.ws;

import java.io.IOException;

import javax.ws.rs.ext.RuntimeDelegate;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.ServerConfiguration;

public class CustomServer {

	public static HttpServer start(String path, String ... extraPath) {
		try {
			HttpServer server = HttpServer.createSimpleServer("http://localhost/", 8000);
			ServerConfiguration configuration = server.getServerConfiguration();
			configuration.setJmxEnabled(true);
			configuration.addHttpHandler(handler(), path);
			server.start();
			return server;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static HttpHandler handler() {
		RuntimeDelegate instance = RuntimeDelegate.getInstance();
		return instance.createEndpoint(new WSApplicationConfig(), HttpHandler.class);
	}
}
