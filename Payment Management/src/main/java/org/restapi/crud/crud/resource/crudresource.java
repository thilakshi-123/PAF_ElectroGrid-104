package org.restapi.crud.crud.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.restapi.crud.crud.model.crudmodel;
import org.restapi.crud.crud.service.crudservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class crudresource {
	
	crudservice service = new crudservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addPayment(crudmodel payment) {
		 return service.insertPayment(payment);
		
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getUser() throws SQLException {
		 return service.getPayment();
		
	}
	
	@Path("/retrieveById/{paymentId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getUser(@PathParam("paymentId") int paymentId) throws SQLException {
		return service.getPaymentById(paymentId);
		
	}
	

	
	@Path("/updatePayment")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel updatePayment(crudmodel payment) {
		 return service.updatetPayment(payment);
		
	}
	
	@Path("/deletePaymentById/{paymentId}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deletetPayment(@PathParam("paymentId") int paymentId) {
		return service.deletetPayment(paymentId);
		
	}

	
}
