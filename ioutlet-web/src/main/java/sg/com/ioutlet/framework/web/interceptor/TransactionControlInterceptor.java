package sg.com.ioutlet.framework.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.jboss.logging.NDC;

import sg.com.ioutlet.ace.user.User;
import sg.com.ioutlet.framework.trxhelper.TransactionControl;
import sg.com.ioutlet.framework.web.WebConstants;
import sg.com.ioutlet.framework.web.action.CommonActionSupport;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

public class TransactionControlInterceptor  extends CommonInterceptor{
	private static final long serialVersionUID = 1L;

	private static final String GUEST = "guest";
	
	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

		
		logger.trace("doIntercept");
		logger.trace("setting transaction control information");
		String result = ActionSupport.ERROR;
		try
		{
		if (actionInvocation.getAction() instanceof CommonActionSupport)
		{
			CommonActionSupport cas = (CommonActionSupport) actionInvocation.getAction();
			String funcId = cas.getFunctionId();
			HttpServletRequest request = getRequest();

			String clientIp = request.getRemoteAddr();
			User userInfo = (User) getSession().get(WebConstants.LOGGED_IN_USER_INFO.toString());
			String processUser=GUEST;
			if(userInfo!=null)
			{
				processUser = userInfo.getUserId();
			}
			HttpSession session = request.getSession();
			
			String sessionId = (String) session.getAttribute(WebConstants.SESSION_ID.toString());
			
			if (StringUtils.isEmpty(sessionId))
			{
				session.setAttribute(WebConstants.SESSION_ID.toString(), TransactionIdGenerator.getUniversallyUniqueID());
			}
			
			TransactionControl.getTransactionInfo().setFunctionId(funcId);
			TransactionControl.getTransactionInfo().setRequestIp(clientIp);
			TransactionControl.getTransactionInfo().setRequestUser(processUser);
			TransactionControl.getTransactionInfo().setRequestLocale(request.getLocale());
			TransactionControl.getTransactionInfo().setDomainId(cas.getDomainId());
			NDC.push(clientIp);
			long start = System.currentTimeMillis();
			result = actionInvocation.invoke();
			long end = System.currentTimeMillis();
			logger.performance(request.getRequestURI(), start, end);
			if (logger.isDebugEnabled())
				logger.debug(actionInvocation.getAction().getClass().getName() + " duration [" + (end - start) + "]");
		
		}
		}
		finally
		{
			NDC.pop();
		}
		return result;
	}
		

}
