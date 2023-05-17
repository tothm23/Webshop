package com.webshop.Controller;

import com.webshop.Model.User;
import com.webshop.Service.UserService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author tothm23
 */
@Path("user")
public class UserController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    /**
     * Retrieves representation of an instance of
     * com.webshop.Controller.UserController
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserController
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("/regisztracio")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response regisztracio(User u) {
        String result = UserService.regisztracio(u.getUsername(), u.getEmail(), u.getPassword(), u.getAdmin());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }
}
