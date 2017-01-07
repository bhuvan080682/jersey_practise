package org.uhc.pharma.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/")
public class DrugsAvailableController {
	
	@GET
	public String getAvailibility(){
		return "available drugs here";
	}
	
	@GET
	@Path("/{id}")
	public String getAvailableMedicineById(@PathParam("id") String id,@Context UriInfo uriInfo){
		System.out.println(uriInfo.getAbsolutePath());
		return "returned drug availability for id" + id;
	}

}
