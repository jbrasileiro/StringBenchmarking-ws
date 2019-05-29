package stringbenchmarking.ws.resource;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import stringbenchmarking.ws.CustomServer;

public class JHMStringenchmarkingExecuteResourceITest {

	@Before
	public void setUp() {
		CustomServer.start("/ti/Execute");
	}
	
	@Test
	public void test()
		throws IOException {
		WebResource webResource = Client.create().resource("http://localhost:8000/ti/Execute");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		Assert.assertEquals(200, response.getStatus());
		Assert.assertEquals("done", response.getEntity(String.class));
	}

}
