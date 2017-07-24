package br.rodolfo.vilaca.webservice;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.rodolfo.vilaca.dto.Product;
@Produces({ "application/xml", "application/json" })
public interface ProductWS {

	@POST
	@Path("/products")
	public Response add(Product product);

	@PUT
	@Path("/products")
	public Response update(Product product);

	@DELETE
	@Path("/products/{id}")
	public Response delete(@PathParam("id") int id);

	@GET
	@Path("/products/{id}")
	public Response find(@PathParam("id") int id);

	@GET
	@Path("/products")
	public Response findAll();
}
