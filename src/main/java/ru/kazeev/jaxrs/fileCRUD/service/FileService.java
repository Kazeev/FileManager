package ru.kazeev.jaxrs.fileCRUD.service;


import ru.kazeev.jaxrs.fileCRUD.dao.AccountEntity;
import ru.kazeev.jaxrs.fileCRUD.dao.DataBase;
import ru.kazeev.jaxrs.fileCRUD.dao.FileEntity;

import javax.enterprise.inject.New;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Path("/file")
public class FileService {
    DataBase dataBase;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFile(@PathParam("id") String id){
        //Person p = new Person("Misha", id);
        for (int i = 0; i < dataBase.getFilesList().size(); i++) {
            if (dataBase.getFilesList().get(i).getId() == Integer.parseInt(id))
                return Response.ok(dataBase.getFilesList().get(i)).build();
        }

        return Response.ok("fuck you").build();
    }
}
