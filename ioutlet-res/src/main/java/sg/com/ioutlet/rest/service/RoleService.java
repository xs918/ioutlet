package sg.com.ioutlet.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriInfo;



import org.apache.commons.lang3.StringUtils;

import sg.com.ioutlet.model.role.Role;
import sg.com.ioutlet.rest.endpoint.RoleEndpoint;
import sg.com.ioutlet.rest.exception.DataNotAcceptableException;
import sg.com.ioutlet.rest.exception.DataNotFoundException;
import sg.com.ioutlet.vo.RoleVo;
import sg.com.ioutlet.vo.utils.VoUtils;

public class RoleService extends CommonService {

	public List<RoleVo> getAllRole(UriInfo uriInfo) {

		List<RoleVo> rvList = new ArrayList<RoleVo>();
		for (Role r : getter.getAllRoles()) {
			RoleVo rv = VoUtils.getRoleVo(r);
			rv.addLink(getUriForSelf(uriInfo, rv), "self");
			rv.addLink(getUriForUser(uriInfo, rv), "users");
			
			rvList.add(rv);
		}
		return rvList;

	}

	public RoleVo getRoleById(UriInfo uriInfo , String id) {

		Role role =  getter.getRoleById(id);
		if(null == role)
		{
			throw new DataNotFoundException("Role did not exist for role - "+id);
		}
		
			
		
		RoleVo roleVo = VoUtils.getRoleVo(role);

		roleVo.addLink(getUriForSelf(uriInfo, roleVo), "self");
		roleVo.addLink(getUriForUser(uriInfo, roleVo), "users");
		
		return roleVo;
		
		

	}

	public RoleVo addRole(RoleVo roleVo) {
		Role newRole = setter.addRole(roleVo);
		if (newRole == null) {
			throw new DataNotAcceptableException("add new role failed - "
					+ roleVo.getName());
		}
		return VoUtils.getRoleVo(newRole);

	}

	public void deleteRole(String id) {

		setter.deleteRole(id);

	}
	private String getUriForSelf(UriInfo uriInfo, RoleVo roleVo) {
		String uri = uriInfo.getBaseUriBuilder().path(RoleEndpoint.class)
				.path(roleVo.getId()).build().toString();
		return uri;
	}
	
	private String getUriForUser(UriInfo uriInfo, RoleVo roleVo) {
		String uri = uriInfo.getBaseUriBuilder().path(RoleEndpoint.class)
				.path(roleVo.getId()).path("users").build().toString();
		return uri;
	}

	

	public RoleVo updateRole(RoleVo roleVo,UriInfo uriInfo) {
		if(StringUtils.isBlank(roleVo.getId()))
		{
			throw new DataNotAcceptableException("Role Id must not be empty or null");
		}
		Role newRole = setter.updateRole(roleVo);
		
		if (newRole == null)
		{
			throw new DataNotFoundException("Update role failed: role did not exist - " + roleVo.getId() );
		}
		RoleVo updateRole =  VoUtils.getRoleVo(newRole);
		updateRole.addLink(getUriForSelf(uriInfo, roleVo), "self");
		return updateRole;
		
	}

}
