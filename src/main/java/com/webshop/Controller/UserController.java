package com.webshop.Controller;

import com.webshop.Model.User;
import com.webshop.Service.UserService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * @author tothm23
 */
@Path("user")
public class UserController {

    public UserController() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok("Hello, World!").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("/regisztracio")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response regisztracio(User u) {
        String result = UserService.regisztracio(u.getNickname(), u.getEmail(), u.getPassword(), u.getIsAdmin());
        return Response.status(Response.Status.OK).entity(result).type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/bejelentkezes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User u) {
        JSONObject result = UserService.bejelentkezes(u.getEmail(), u.getPassword());
        return Response.status(Response.Status.OK).entity(result.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
