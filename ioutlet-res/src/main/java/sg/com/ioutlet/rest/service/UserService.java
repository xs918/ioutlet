package sg.com.ioutlet.rest.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang3.StringUtils;

import sg.com.ioutlet.model.user.User;
import sg.com.ioutlet.rest.endpoint.RoleEndpoint;
import sg.com.ioutlet.rest.endpoint.UserEndpoint;
import sg.com.ioutlet.rest.exception.DataNotAcceptableException;
import sg.com.ioutlet.rest.exception.DataNotFoundException;
import sg.com.ioutlet.vo.UserVo;
import sg.com.ioutlet.vo.utils.VoUtils;

public class UserService extends CommonService {

	public List<UserVo> getAllUsers(UriInfo uriInfo) {

		List<UserVo> uvList = new ArrayList<UserVo>();
		for (User u : getter.getAllUsers()) {
			UserVo uv = VoUtils.getUserVo(u);
			uv.addLink(getUriForSelf(uriInfo, uv), "self");
			uv.addLink(getUriForRole(uriInfo, uv), "role");
			uvList.add(uv);
		}
		return uvList;

	}

	public  List<UserVo> getUsersByRole(UriInfo uriInfo, String roleId) {
		List<UserVo> uvList = new ArrayList<UserVo>();
		for (User u : getter.getAllUsersByRoleId(roleId)) {
			UserVo uv = VoUtils.getUserVo(u);
			uv.addLink(getUriForSelf(uriInfo, uv), "self");
			uv.addLink(getUriForRole(uriInfo, uv), "role");
			uvList.add(uv);
		}
		return uvList;
		
	}

	
	
	public UserVo getUserById(String userId,UriInfo uriInfo) {
		User usr =  getter.getUserById(userId);
		if(usr == null)
		{
			throw new DataNotFoundException("User did not exist for id - "+ userId);
		}
		UserVo uv = VoUtils.getUserVo(usr);
		uv.addLink(getUriForSelf(uriInfo, uv), "self");
		uv.addLink(getUriForRole(uriInfo, uv), "role");
		
	
		return uv;
	}
	public Response addUser(UserVo userVo, UriInfo uriInfo) {
		User usr =  setter.addUser(userVo);
		if(usr==null)
		{
			throw new DataNotFoundException("add new user failed - "+ userVo.getName());
		}
		
		UserVo  newUsrVo = VoUtils.getUserVo(usr);
		
		URI uri = uriInfo.getBaseUriBuilder().path(UserEndpoint.class).path(newUsrVo.getId()).build();
		newUsrVo.addLink(uri.toString(), "self");
		newUsrVo.addLink(getUriForRole(uriInfo, newUsrVo), "role");
		
		return Response.created(uri).entity(newUsrVo).build();
	}
	
	
	public Response updateUser(UserVo userVo, UriInfo uriInfo) {
		if(StringUtils.isBlank(userVo.getId()))
		{
			throw new DataNotAcceptableException("User Id must not be empty or null");
		}
		User usr =  setter.updateUser(userVo);
		if (usr == null)
		{
			throw new DataNotFoundException("Update user failed: user did not exist - " + userVo.getId() );
		}
		
		UserVo updatedVo = VoUtils.getUserVo(usr);
		
		URI uri = uriInfo.getBaseUriBuilder().path(UserEndpoint.class).path(updatedVo.getId()).build();
		updatedVo.addLink(uri.toString(), "self");
		updatedVo.addLink(getUriForRole(uriInfo, updatedVo), "role");
		return Response.created(uri).entity(updatedVo).build();
	}

	public void deleteUser(String userId) {
		setter.deleteUser(userId);
		
	}

	
	
	
	
	private String getUriForSelf(UriInfo uriInfo, UserVo userVo) {
		String uri = uriInfo.getBaseUriBuilder().path(UserEndpoint.class)
				.path(userVo.getId()).build().toString();
		return uri;
	}

	private String getUriForRole(UriInfo uriInfo, UserVo userVo) {
		String uri = uriInfo.getBaseUriBuilder().path(RoleEndpoint.class)
				.path(userVo.getRoleId()).build().toString();
		return uri;
	}


	

	
}
