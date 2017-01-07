package org.uhc.pharma.controller;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.uhc.pharma.model.DrugsBean;
import org.uhc.pharma.model.DrugsFilterBean;
import org.uhc.pharma.service.DrugsService;
import org.uhc.pharma.service.DrugsServiceImpl;



@Path("api/pharma")
public class DrugsController {
	private DrugsService drugsService= new DrugsServiceImpl();
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String welcomeMessage(){
		return "Welcome to Unnathi Medicals";
	}
	
	@Path("/All")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDrugs(){
		List<DrugsBean> drugs = drugsService.getAllDrugs();
		return Response.status(Status.OK).entity(drugs).build();
		
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDrugById(@PathParam("id") int id){
		DrugsBean drug = drugsService.getDrugById(id);
		return Response.status(Status.OK).entity(drug).build();
		//DrugsBean drug = new DrugsBean("Calpol 650", "Paracetamol 650 mg", "Cadilla");
		//DrugsBean d1 = new DrugsBean("DOLO 650", "Paracetamol 650 mg", "Micro Labs");
		//return drugsService.addDrug(d1);
	}
	
	@Path("/drug")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDrug(DrugsBean drug){
		
		int id = drugsService.addDrug(drug);
		return Response.status(Status.CREATED).entity(id).build();
	}
	
	
	@Path("/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDrug(DrugsBean drug){
		drugsService.modifyDrug(drug);
		return Response.status(Status.OK).build();
	}
	
	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteDrug(@PathParam("id") int id){
		drugsService.removeDrug(id);
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("/filtering")
	public List<DrugsBean> drugsByFiltering(@QueryParam("company")String company,@QueryParam("name")String name){
		return drugsService.getDrugsByCondition(company, name);
	}
	
	@GET
	@Path("/paramAnnotations")
	@Produces(value={MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
	public String getParamValues(@HeaderParam("user") String user,
								 @HeaderParam("customVal") String customVal,
								 @CookieParam("val") String val){
		
		String userValHeader = user;
		String customValHeader = customVal;
		String cookieVal = val;
		
		return "userValHeader :" + userValHeader + "  customVal : " + customValHeader + "  cookieVal" + cookieVal;
		
	}
	
	
	@GET
	@Path("/contextParam/{val}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getContextValues(@Context UriInfo uriInfo,@Context HttpHeaders header){
		
		MultivaluedMap<String, String> pathParam = uriInfo.getPathParameters();
		System.out.println("header.user : "+header.getHeaderString("user"));
		System.out.println("length : "+header.getLength());
		System.out.println("AcceptableLanguages : "+header.getAcceptableLanguages());
		System.out.println("AcceptableMediaTypes : "+header.getAcceptableMediaTypes());
		System.out.println("Date : "+header.getDate());
		System.out.println("Language : "+header.getLanguage());
		System.out.println("MediaType : "+header.getMediaType());
		System.out.println("requestHeaders :"+header.getRequestHeaders());
		return "uriInfo.Path : " + uriInfo.getPath()  + "\n"
				+" uriInfo.AbsolutePath : " + uriInfo.getAbsolutePath() + "\n"
				+ " uriInfo.PathParameters " + pathParam;
				
		
	}
	
	
	@GET
	@Path("/beanParam")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBeanParamValues(@BeanParam DrugsFilterBean drugsFilterBean ){
		
		String userValHeader = drugsFilterBean.getUser();
		String customValHeader = drugsFilterBean.getCustomVal();
		String cookieVal = drugsFilterBean.getVal();
		
		return "userValHeader :" + userValHeader + "  customVal : " + customValHeader + "  cookieVal" + cookieVal;
		
	}
	
	@Path("/{id}/available")
	public DrugsAvailableController getDrugsAvailable(){
		return new DrugsAvailableController();
	}
}
