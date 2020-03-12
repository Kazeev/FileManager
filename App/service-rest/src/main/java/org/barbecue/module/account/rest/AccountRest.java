package org.barbecue.module.account.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.barbecue.module.account.dto.AccountDto;
import org.barbecue.module.account.setvice.AccountCervices;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;



@Path("account")
public class AccountRest {

    @GET
    @RolesAllowed("Admin")
    @Path("/{userId}")
    public Response getUser(@PathParam("userId") Integer userId) throws SQLException, JsonProcessingException {
        String json = AccountCervices.getUserById(userId);
        return Response.ok(json).build();
    }

    @GET
    @RolesAllowed("Admin")
    public Response getAllUser() throws SQLException, JsonProcessingException {
        String json = AccountCervices.getAllUser();
        return Response.ok(json).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response  createUser(AccountDto account) throws SQLException {
        AccountCervices.createUser(account);
        return Response.ok().build();
    }

}
