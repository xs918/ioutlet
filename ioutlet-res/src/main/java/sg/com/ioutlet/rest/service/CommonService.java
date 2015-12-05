package sg.com.ioutlet.rest.service;

import sg.com.ioutlet.bridge.AceBridge;
import sg.com.ioutlet.bridge.GetterBridge;
import sg.com.ioutlet.bridge.SetterBridge;
import sg.com.ioutlet.rest.common.IoutletBridgerLookup;

public class CommonService {
	GetterBridge getter = IoutletBridgerLookup.lookupGetterBridge();
	SetterBridge setter= IoutletBridgerLookup.lookupSetterBridge();
	AceBridge ace= IoutletBridgerLookup.lookupAceBridge();
	


}
