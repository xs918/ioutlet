package sg.com.ioutlet.rest.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;

import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.rest.endpoint.OutletEndpoint;
import sg.com.ioutlet.rest.exception.DataNotAcceptableException;
import sg.com.ioutlet.rest.exception.DataNotFoundException;
import sg.com.ioutlet.vo.OutletVo;
import sg.com.ioutlet.vo.utils.VoUtils;

public class OutletService extends CommonService {

	public List<OutletVo> getAllOutlets(UriInfo uriInfo) {

		List<OutletVo> uvList = new ArrayList<OutletVo>();
		for (Outlet o : getter.getAllOutlets()) {
			OutletVo ov = VoUtils.getOutletVo(o);
			ov.addLink(getUriForSelf(uriInfo, ov), "self");
			uvList.add(ov);
		}
		return uvList;

	}


	
	
	public OutletVo getOutletById(String outletId,UriInfo uriInfo) {
		Outlet usr =  getter.getOutletById(outletId);
		if(usr == null)
		{
			throw new DataNotFoundException("Outlet did not exist for id - "+ outletId);
		}
		OutletVo uv = VoUtils.getOutletVo(usr);
		uv.addLink(getUriForSelf(uriInfo, uv), "self");
	
		return uv;
	}
	public Response addOutlet(OutletVo outletVo, UriInfo uriInfo) {
		Outlet usr =  setter.addOutlet(outletVo);
		if(usr==null)
		{
			throw new DataNotFoundException("add new outlet failed - "+ outletVo.getName());
		}
		
		OutletVo  newUsrVo = VoUtils.getOutletVo(usr);
		
		URI uri = uriInfo.getBaseUriBuilder().path(OutletEndpoint.class).path(newUsrVo.getId()).build();
		newUsrVo.addLink(uri.toString(), "self");
		
		return Response.created(uri).entity(newUsrVo).build();
	}
	
	
	public Response updateOutlet(OutletVo outletVo, UriInfo uriInfo) {
		if(StringUtils.isBlank(outletVo.getId()))
		{
			throw new DataNotAcceptableException("Outlet Id must not be empty or null");
		}
		Outlet usr =  setter.updateOutlet(outletVo);
		if (usr == null)
		{
			throw new DataNotFoundException("Update outlet failed: outlet did not exist - " + outletVo.getId() );
		}
		
		OutletVo updatedVo = VoUtils.getOutletVo(usr);
		
		URI uri = uriInfo.getBaseUriBuilder().path(OutletEndpoint.class).path(updatedVo.getId()).build();
		updatedVo.addLink(uri.toString(), "self");
		return Response.created(uri).entity(updatedVo).build();
	}

	public void deleteOutlet(String outletId) {
		setter.deleteOutlet(outletId);
		
	}

	
	
	
	
	private String getUriForSelf(UriInfo uriInfo, OutletVo outletVo) {
		String uri = uriInfo.getBaseUriBuilder().path(OutletEndpoint.class)
				.path(outletVo.getId()).build().toString();
		return uri;
	}


	
}
