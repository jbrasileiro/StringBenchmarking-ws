package stringbenchmarking.ws.resource;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/Execute")
public class JHMStringenchmarkingExecuteResource {

	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public Response execute() {
		try {
			return Response.ok("done").build();
		} catch (Exception e) {
			throw new WebApplicationException(e, Response.serverError().build());
		}
	}
}
