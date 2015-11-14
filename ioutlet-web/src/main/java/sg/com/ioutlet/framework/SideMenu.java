package sg.com.ioutlet.framework;

public class SideMenu {
	enum adminIndex
	{
		adminHome("Outlet Admin"),link("adminhomeindex");
		private String s;
		
		adminIndex(String s)
		{
			this.s=s;
		}
		
		public String toString()
		{
			return s;
		}
	}
	
	private adminIndex adminIndex;

	public adminIndex getAdminIndex() {
		return adminIndex;
	}

	public void setAdminIndex(adminIndex adminIndex) {
		this.adminIndex = adminIndex;
	}
	

}
