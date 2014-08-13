package amigo.sshmemo.action.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.commons.beanutils.BeanUtils;

import amigo.sshmemo.dao.User;
import amigo.sshmemo.service.user.UserForm;
import amigo.sshmemo.service.user.UserManager;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserForm user;

	private HttpServletRequest request;

	private Map<String, String> session;

	private UserManager userManager;

	public UserForm getUser() {
		return user;
	}

	public void setUser(UserForm user) {
		this.user = user;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String login() throws Exception {
		boolean flagSuccess = userManager.userLogin(user.getUsername(), user.getPassword());
		List<User> userList = this.userManager.getUserList();
		request.setAttribute("userList", userList);
		if (flagSuccess) {
			session.put("username", user.getUsername());
			return "main";
		} else {
			request.setAttribute("message", "µÇÂ¼Ê§°Ü£¡");
			return "login";
		}
	}

	public String reg() throws Exception {
		userManager.saveUser(user);
		return "main";
	}

	public String initUpdate() throws Exception {
		String username = request.getParameter("username");
		User userObject = userManager.getUser(username);
		BeanUtils.copyProperties(user, userObject);
		return "update";
	}

	public String update() throws Exception {
		userManager.updateUser(user);
		return this.list();
	}

	public String delete() throws Exception {
		String[] usernames = request.getParameterValues("username");
		this.userManager.deleteUser(usernames);
		return this.list();
	}

	public String list() throws Exception {
		List<User> userList = this.userManager.getUserList();
		request.setAttribute("userList", userList);
		return "list";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	@Override
	public void setSession(Map arg0) {
		this.session = arg0;

	}

}
