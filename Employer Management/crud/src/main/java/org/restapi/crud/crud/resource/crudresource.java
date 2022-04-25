package org.restapi.crud.crud.resource;

import java.sql.SQLException;
import java.util.ArrayList;

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

@Path("/employer")
public class crudresource {
	
	crudservice service = new crudservice();
	
	//insertion
	@Path("/insertion") 
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addEmp(crudmodel emp) {
		 return service.insertEmp(emp);
		
	}
	
	//retrieve
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getEmp() throws SQLException {
		 return service.getEmp();
		
	}
	
	@Path("/retrieveById/{empid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getEmp(@PathParam("empid") int empid) throws SQLException {
		return service.getEmpById(empid);
		
	}
	

	
	@Path("/updateEmp")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel updateEmp(crudmodel emp) {
		 return service.updateEmp(emp);
		
	}
	
	@Path("/deleteEmpById/{empid}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteEmp(@PathParam("empid") int empid) {
		return service.deletetEmp(empid);
		
	}

	
	
}
