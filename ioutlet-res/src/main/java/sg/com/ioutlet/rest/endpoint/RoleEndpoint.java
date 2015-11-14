package sg.com.ioutlet.rest.endpoint;

import java.net.URI;
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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import sg.com.ioutlet.rest.service.RoleService;
import sg.com.ioutlet.rest.service.UserService;
import sg.com.ioutlet.vo.RoleVo;
import sg.com.ioutlet.vo.UserVo;

@Path("/roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoleEndpoint {
	RoleService roleService = new RoleService();

	@GET
	public List<RoleVo> getAllRoles(@Context UriInfo uriInfo) {

		return roleService.getAllRole(uriInfo);

	}

	@GET
	@Path("/{roleId}")
	public RoleVo getRoleById(@PathParam("roleId") String roleId,
			@Context UriInfo uriInfo) {

		return roleService.getRoleById(uriInfo, roleId);

	}

	@GET
	@Path("/{roleId}/users")
	public List<UserVo> getUsersByRole(@PathParam("roleId") String roleId,
			@Context UriInfo uriInfo) {

		UserService userService = new UserService();

		return userService.getUsersByRole(uriInfo, roleId);

	}

	@PUT
	@Path("/{roleId}")
	public RoleVo updateRole(@PathParam("roleId") String id, RoleVo roleVo,
			@Context UriInfo uriInfo) {
		roleVo.setId(id);
		return roleService.updateRole(roleVo, uriInfo);
	}

	@POST
	public Response addRole(RoleVo roleVo, @Context UriInfo uriInfo) {

		RoleVo newVo = roleService.addRole(roleVo);
		String newId = newVo.getId();
		URI uri = uriInfo.getBaseUriBuilder().path(RoleEndpoint.class)
				.path(newId).build();
		newVo.addLink(uri.toString(), "self");
		return Response.created(uri).entity(newVo).build();
	}

	@DELETE
	@Path("/{roleId}")
	public Response deleteRole(@PathParam("roleId") String roleId) {
		roleService.deleteRole(roleId);

		return Response.status(Status.OK).build();
	}

}
