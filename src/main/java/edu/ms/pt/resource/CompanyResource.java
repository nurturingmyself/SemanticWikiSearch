package edu.ms.pt.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import edu.ms.pt.sparql.access.Company;
import edu.ms.pt.sparql.access.DBPediaSAO;

@Path("/{name}")
public class CompanyResource extends Resource{
	
	private static final Logger LOGGER = Logger.getLogger(CompanyResource.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompanyInfo(@PathParam("name") String name) {
		LOGGER.info("The control is now CompanySearch Servlet");
		
		Company company = new DBPediaSAO().getCompanyInfo(name, uriInfo);
		return Response.ok().entity(company).build();
	}
	
}