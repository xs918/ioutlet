package sg.com.ioutlet.vo.utils;

import sg.com.ioutlet.ace.role.Role;
import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.bas.CommonPojo;
import sg.com.ioutlet.model.outlet.Outlet;
import sg.com.ioutlet.vo.CommonVo;
import sg.com.ioutlet.vo.OutletVo;
import sg.com.ioutlet.vo.RoleVo;
import sg.com.ioutlet.vo.UserVo;

public class VoUtils {
	public static String DEFAULT_DATE_FORMATING = "dd/MM/yyyy HH:mm:ss";

	public static RoleVo getRoleVo(Role role) {
		RoleVo vo = new RoleVo();
		vo.setId(role.getKey().getUuid());
		vo.setName(role.getName());
		vo.setDescription(role.getDescription());
		populateCommonFields(vo,role);
		return vo;

	}
	


	public static UserVo getUserVo(User user) {

		UserVo vo = new UserVo();

		vo.setId(user.getKey().getUuid());
		vo.setEmailId(user.getEmailId());

		vo.setPassword(user.getPassword());

		vo.setName(user.getName());
		vo.setGender(user.getGender());
		vo.setBirthDay(user.getDayOfBirth());

		vo.setOtherDetail(user.getDescription());

			vo.setLangCode(user.getLangCode());
		vo.setCurrLoc(user.getCurrLoc());
		vo.setRewardPoint(user.getRewardPoint());
		populateCommonFields(vo,user);
		
		return vo;

	}
	private static void populateCommonFields(CommonVo vo, CommonPojo pojo)
	{
			vo.setCreationTime(pojo.getCreationTime());
		vo.setLudUser(pojo.getLudUser());
		vo.setLudPgm(pojo.getLudPgm());
		vo.setLudTime(pojo.getLudTime());
	}



	public static OutletVo getOutletVo(Outlet o) {
		OutletVo  vo = new OutletVo();
		
		vo.setId(o.getKey().getUuid());
		vo.setAddr1(o.getAddr1());
		vo.setAddr2(o.getAddr2());
		vo.setAddr3(o.getAddr3());
		vo.setAddr4(o.getAddr4());
		vo.setAddr5(o.getAddr5());
        vo.setDescription(o.getDescription());
        vo.setWeekDayWorkingTime(o.getWeekDayWorkingTime());
        vo.setSaturdayWorkingTime(o.getSaturdayWorkingTime());
        vo.setSundayWorkingTime(o.getSundayWorkingTime());
        vo.setPublicHolidayWorkingTime(o.getPublicHolidayWorkingTime());
        vo.setName(o.getName());
        vo.setLogo(o.getLogo());
        vo.setTelPhone(o.getTelPhone());
        vo.setFaxNo(o.getFaxNo());
        vo.setEmail(o.getEmail());
        vo.setPostCode(o.getPostCode());
    	populateCommonFields(vo,o);
    	return vo;
    	
    	
    	
	}
	
}
