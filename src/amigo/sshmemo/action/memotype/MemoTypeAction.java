package amigo.sshmemo.action.memotype;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import amigo.sshmemo.dao.MemoType;
import amigo.sshmemo.service.memotype.MemoTypeManager;

import com.opensymphony.xwork2.ActionSupport;

public class MemoTypeAction extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private long typeId;

	private HttpServletRequest request;

	private Map<String, String> session;

	private MemoTypeManager memoTypeManager;

	@Override
	public void setSession(Map map) {
		this.session = map;

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;

	}
	
	public String save() throws Exception{
		String username = session.get("username");
		this.memoTypeManager.saveMemoType(name, username);
		return this.list();
	}
	
	public String initUpdate() throws Exception{
		String type = request.getParameter("type");
		MemoType memoType = memoTypeManager.getMemoType(Long.parseLong(type));
		typeId = Long.parseLong(type);
		name = memoType.getName();
		return "update";
		
	}
	
	public String update() throws Exception{
		String type = request.getParameter("type");
		memoTypeManager.updateMemoType(Long.parseLong(type),name);
		return this.list();
	}
	
	public String delete() throws Exception{
		String[] types = request.getParameterValues("type");
		memoTypeManager.deleteMemoType(types);
		return this.list();
	}
	
	public String list() throws Exception{
		String username = session.get("username");
		List<MemoType> memoTypeList = memoTypeManager.getMemoTypeList(username);
		request.setAttribute("memoTypeList", memoTypeList);
		return "list";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public void setMemoTypeManager(MemoTypeManager memoTypeManager) {
		this.memoTypeManager = memoTypeManager;
	}

}
