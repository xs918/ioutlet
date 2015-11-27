package sg.com.ioutlet.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -922774330568464424L;

	private String creationUser;

	private String creationPgm;

	private Date creationTime;

	private String ludUser;

	private Date ludTime;

	private String ludPgm;

	private List<Link> links = new ArrayList<>();

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getCreationPgm() {
		return creationPgm;
	}

	public void setCreationPgm(String creationPgm) {
		this.creationPgm = creationPgm;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public String getLudUser() {
		return ludUser;
	}

	public void setLudUser(String ludUser) {
		this.ludUser = ludUser;
	}

	public Date getLudTime() {
		return ludTime;
	}

	public void setLudTime(Date ludTime) {
		this.ludTime = ludTime;
	}

	public String getLudPgm() {
		return ludPgm;
	}

	public void setLudPgm(String ludPgm) {
		this.ludPgm = ludPgm;
	}

	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

}
