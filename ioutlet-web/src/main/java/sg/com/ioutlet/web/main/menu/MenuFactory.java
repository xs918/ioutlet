package sg.com.ioutlet.web.main.menu;

import java.util.List;

import sg.com.ioutlet.web.common.action.AccessController;
import sg.com.ioutlet.web.common.action.IoutletMenuDisplayAction;

public class MenuFactory {
	public List<MenuGroup> generateMenus(String sbmu, AccessController ac) {
		List<MenuGroup> mg = null;
		IoutletMenuDisplayAction action = new IoutletMenuDisplayAction();
		mg = action.generateMenus(ac);
		return mg;
	}
}
