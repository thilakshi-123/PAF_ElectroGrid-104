package com.fund.resource;

import com.fund.model.fundmodel;
import com.fund.service.fundservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/fund")
public class fundresource {
    fundservice service = new fundservice();

    @Path("/insertion")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public fundmodel addFund(fundmodel fund) {
        return service.insertFund(fund);

    }

    @Path("/retrieve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<fundmodel> getFund() throws SQLException {
        return service.getFund();

    }

    @Path("/retrieveById/{fundId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<fundmodel>  getFund(@PathParam("fundId") int fundId) throws SQLException {
        return service.getFundById(fundId);

    }



    @Path("/updateFund")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public fundmodel updateFund(fundmodel fund) {
        return service.updateFund(fund);

    }

    @Path("/deleteFundById/{fundId}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public int deleteFund(@PathParam("fundId") int fundId) {
        return service.deleteFund(fundId);
    }
}
