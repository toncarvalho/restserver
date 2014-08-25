package restserver.services;

import javax.ejb.LocalBean;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/status")
@RequestScoped
@LocalBean
public class ServerStatusRest {
    @GET
    public Response status() {

        return Response.status(Response.Status.OK).build();
    }
}
