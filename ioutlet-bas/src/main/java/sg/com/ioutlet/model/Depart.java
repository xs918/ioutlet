package sg.com.ioutlet.model;

import java.io.Serializable;


/**
 * The persistent class for the depart database table.
 * 
 */
public class Depart implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	private String location;

	private String name;

	public Depart() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}