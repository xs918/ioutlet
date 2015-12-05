package sg.com.ioutlet.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import sg.com.ioutlet.ace.role.Role;
@XmlRootElement
public class RoleVo {
	Role role;
	private List<Link> links = new ArrayList<>();

	public RoleVo(Role role) {
		this.role = role;

	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
}
