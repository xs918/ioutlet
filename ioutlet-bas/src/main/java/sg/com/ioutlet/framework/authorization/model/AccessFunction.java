package sg.com.ioutlet.framework.authorization.model;

public interface AccessFunction {
	public String getUuid();
	public String getId();
	public String getName();
	public String getNamespace();
	public String getAction();
}
