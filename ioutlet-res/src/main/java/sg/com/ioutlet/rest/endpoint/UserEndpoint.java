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

import sg.com.ioutlet.rest.service.UserService;
import sg.com.ioutlet.vo.UserVo;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserEndpoint {
	UserService userService = new UserService();

	@GET
	public List<UserVo> getAllUsers(@Context UriInfo uriInfo) {

		return userService.getAllUsers(uriInfo);

	}

	@GET
	@Path("/{userId}")
	public UserVo getUserById(@PathParam("userId") String userId,
			@Context UriInfo uriInfo) {
		return userService.getUserById(userId, uriInfo);

	}

	@POST
	public Response addUser(UserVo userVo, @Context UriInfo uriInfo)
	{

		return userService.addUser(userVo, uriInfo);
	}

	@PUT
	@Path("/{userId}")
	public Response updateUser(@PathParam("userId") String userId, UserVo userVo, @Context UriInfo uriInfo) {
		userVo.setId(userId);
		return userService.updateUser(userVo, uriInfo);

	}
	
	@DELETE
	@Path("/{userId}")
	public Response deleteUser(@PathParam("userId") String userId) {
		  userService.deleteUser(userId);
		  return Response.status(Status.OK)
					.build();

	}

}
