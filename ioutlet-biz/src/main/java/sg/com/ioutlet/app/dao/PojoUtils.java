package sg.com.ioutlet.app.dao;

import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.role.RoleKey;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.vo.OutletVo;
import sg.com.ioutlet.vo.RoleVo;
import sg.com.ioutlet.vo.UserVo;



public class PojoUtils {

	public static Role updateRoleFromVo( Role role, RoleVo roleVo) {
		role.setName(roleVo.getName());
		role.setDescription(roleVo.getDescription());
		return role;

	}

	public static User updateUserFromVo(User user, UserVo userVo) {

		user.setEmailId(userVo.getEmailId());
		user.setPassword(userVo.getPassword());
		user.setName(userVo.getName());
		user.setGender(userVo.getGender());
		user.setLangCode(userVo.getLangCode());
		user.setCurrLoc(userVo.getCurrLoc());

		RoleKey roleKey = new RoleKey(userVo.getRoleId());
		user.setRewardPoint(userVo.getRewardPoint());

		return user;
	}

	public static void updateOutletFromVo(Outlet updateOutlet, OutletVo o) {
		
		updateOutlet.setAddr1(o.getAddr1());
		updateOutlet.setAddr2(o.getAddr2());
		updateOutlet.setAddr3(o.getAddr3());
		updateOutlet.setAddr4(o.getAddr4());
		updateOutlet.setAddr5(o.getAddr5());
        updateOutlet.setDescription(o.getDescription());
        updateOutlet.setWeekDayWorkingTime(o.getWeekDayWorkingTime());
        updateOutlet.setSaturdayWorkingTime(o.getSaturdayWorkingTime());
        updateOutlet.setSundayWorkingTime(o.getSundayWorkingTime());
        updateOutlet.setPublicHolidayWorkingTime(o.getPublicHolidayWorkingTime());
        updateOutlet.setName(o.getName());
        updateOutlet.setLogo(o.getLogo());
        updateOutlet.setTelPhone(o.getTelPhone());
        updateOutlet.setFaxNo(o.getFaxNo());
        updateOutlet.setEmail(o.getEmail());
        updateOutlet.setPostCode(o.getPostCode());
    	
	}
}
