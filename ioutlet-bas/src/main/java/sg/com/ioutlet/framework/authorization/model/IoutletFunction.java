package sg.com.ioutlet.framework.authorization.model;

public enum IoutletFunction 
{
	    ALL_FUNC("*"),
	    IOLT_SIDE_MENU("sidebar"),
	    IOLT_MAIN_PAGE("main"),
	    IOLT_DASH_BOARD("dash"),
        IOLT_PRODUCTS("product"), 
        IOLT_ORDERS("order"),
        IOLT_COLLECTIONS("col"),
        IOLT_PAYMENTS("pay"),
        IOLT_CUSTOMERS("cust"),
        IOLT_OUTLETS("out"),
        
    	//* SUB MENU LIST***/
        PAY_CREDIT_CARDS(IOLT_PAYMENTS.inModule()),
        PAY_PAYPAL_CARDS(IOLT_PAYMENTS.inModule()),
        PAY_ALIPAY_CARDS(IOLT_PAYMENTS.inModule()),
        
        
        CUS_IN_DOOR(IOLT_CUSTOMERS.inModule()),
        CUS_OUT_DOOR(IOLT_CUSTOMERS.inModule()), 
        IOLT_DISCOUNTS("dis"), 
        IOLT_SALES_CHART("m7"), 
        IOLT_CUST_CHART,
        IOLT_STAFF;
        
        
		private String module;
		private boolean menuItem=true;
	
		private IoutletFunction(){
			
		}
		
		private IoutletFunction(String module){
			this.module = module;
		}
		
		private IoutletFunction(String module,boolean menuItem){
			this.module = module;
			this.menuItem=menuItem;
		}
		
		public String inModule(){
			return this.module;
		}
		
		public String toString(){
			return this.name();
		}
		
		public boolean isMenuItem()
		{
			return menuItem;
		}
	
		public void setMenuItem(boolean menuItem)
		{
			this.menuItem = menuItem;
		}
		
}