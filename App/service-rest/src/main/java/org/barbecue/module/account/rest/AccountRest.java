package org.barbecue.module.account.rest;

import org.barbecue.module.account.dao.AccountDao;
import org.barbecue.module.account.dto.AccountDto;

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
    AccountDao dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response getUser(@PathParam("userId") Integer userId) throws SQLException {
        AccountDto account = dao.find(userId) ;
        return Response.ok(account).build();
    }
}
