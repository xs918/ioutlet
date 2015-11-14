package sg.com.ioutlet.rest.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import sg.com.ioutlet.rest.service.OutletService;
import sg.com.ioutlet.vo.OutletVo;

@Path("/outlets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OutletEndpoint {
	OutletService outletService = new OutletService();

	@GET
	public List<OutletVo> getAllOutlets(@Context UriInfo uriInfo) {

		return outletService.getAllOutlets(uriInfo);

	}

	@GET
	@Path("/{outletId}")
	public OutletVo getOutletById(@PathParam("outletId") String outletId,
			@Context UriInfo uriInfo) {
		return outletService.getOutletById(outletId, uriInfo);

	}

	@POST
	public Response addOutlet(OutletVo outletVo, @Context UriInfo uriInfo)
	{

		return outletService.addOutlet(outletVo, uriInfo);
	}

	@PUT
	@Path("/{outletId}")
	public Response updateOutlet(@PathParam("outletId") String outletId, OutletVo outletVo, @Context UriInfo uriInfo) {
		outletVo.setId(outletId);
		return outletService.updateOutlet(outletVo, uriInfo);

	}
	
	@DELETE
	@Path("/{outletId}")
	public Response deleteOutlet(@PathParam("outletId") String outletId) {
		  outletService.deleteOutlet(outletId);
		  return Response.status(Status.OK)
					.build();

	}

}
