package amigo.sshmemo.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

;;

public class SessionInterceptor extends AbstractInterceptor implements StrutsStatics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		Map session = context.getSession();
		String username = (String) session.get("username");
		if (username == null) {
			request.setAttribute("message", "¶Ô²»Æð£¬ÄúÎ´µÇÂ¼£¬ÇëÏÈµÇÂ¼");
			return Action.LOGIN;
		}
		String s = invocation.invoke();
		return s;
	}

}
