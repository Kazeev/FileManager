package org.barbecue.module.account.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.barbecue.module.account.dao.AccountDaoImp;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Root resource (exposed at "myresource" path)
 */

@Path("account")
public class AccountRest {
    AccountDaoImp dao = new AccountDaoImp();

    @RolesAllowed("User")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }

    @RolesAllowed("User")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response getUser(@PathParam("userId") Integer userId) throws SQLException, JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(dao.find(userId));
        return Response.ok(json).build();
    }
}
