package sg.com.ioutlet.model;

public enum DataType {
	
C("CHAR"),I("INT"),N("NUMBER"),B("BOOL"),E("EMAIL");

private String dataType;	

DataType(String dataType)
{
	this.setDataType(dataType);
}

private void setDataType(String dataType) {
	this.dataType = dataType;
	
}

public String getDataType() {
	return dataType;
}


}
