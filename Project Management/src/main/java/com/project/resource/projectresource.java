package com.project.resource;

import com.project.model.projectmodel;
import com.project.service.projectservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/project")
public class projectresource {
    projectservice service = new projectservice();

    @Path("/insertion")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public projectmodel addProject(projectmodel project) {
        return service.insertProject(project);

    }

    @Path("/retrieve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<projectmodel> getProject() throws SQLException {
        return service.getProject();

    }

    @Path("/retrieveById/{projectId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<projectmodel>  getProject(@PathParam("projectId") int projectId) throws SQLException {
        return service.getProjectById(projectId);

    }



    @Path("/updateProject")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public projectmodel updateProject(projectmodel project) {
        return service.updateProject(project);

    }

    @Path("/deleteProjectById/{projectId}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public int deleteProject(@PathParam("projectId") int projectId) {
        return service.deleteProject(projectId);

    }
}
