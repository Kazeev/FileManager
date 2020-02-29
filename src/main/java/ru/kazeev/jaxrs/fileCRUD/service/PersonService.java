package ru.kazeev.jaxrs.fileCRUD.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ABarmin on 25.02.2016.
 */
@Path("/file")
public class PersonService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") String id){
        String s ="1231";
        return Response.ok(s).build();
    }

}
