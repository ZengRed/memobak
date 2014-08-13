package amigo.sshmemo.action.memo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.commons.beanutils.BeanUtils;

import amigo.sshmemo.dao.Memo;
import amigo.sshmemo.dao.MemoType;
import amigo.sshmemo.service.memo.MemoForm;
import amigo.sshmemo.service.memo.MemoManager;
import amigo.sshmemo.service.memotype.MemoTypeManager;

import com.opensymphony.xwork2.ActionSupport;

public class MemoAction extends ActionSupport implements ServletRequestAware,
		SessionAware {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;

	private Map<String, String> session;

	@Override
	public void setSession(Map arg0) {
		this.session = arg0;

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;

	}

	private MemoForm memo;

	private List memoTypes;

	private MemoManager memoManager;

	private MemoTypeManager memoTypeManager;

	public String initSave() throws Exception {
		String username = session.get("username");
		List<MemoType> memoTypeList = memoTypeManager.getMemoTypeList(username);
		setMemoTypes(memoTypeList);
		memo = new MemoForm();
		return "save";
	}

	public String save() throws Exception {
		String username = session.get("username");
		memo.setUsername(username);
		memoManager.saveMemo(memo);
		return this.list();
	}

	public String initUpdate() throws Exception {
		String username = session.get("username");
		List<MemoType> memoTypeList = memoTypeManager.getMemoTypeList(username);
		this.setMemoTypes(memoTypeList);
		String memoId = request.getParameter("memoId");
		Memo memoObj = memoManager.getMemoById(Long.parseLong(memoId));
		memo = new MemoForm();
		BeanUtils.copyProperties(memo, memoObj);
		return "update";

	}

	public String update() throws Exception {
		MemoForm test = memo;
		this.memoManager.updateMemo(test);
		return this.list();
	}

	public String delete() throws Exception {
		String[] memoIds = request.getParameterValues("memoId");
		memoManager.deleteMemo(memoIds);
		return this.list();
	}

	public String list() throws Exception {
		String username = session.get("username");
		List<Memo> memoList = memoManager.getMemoList(username);
		request.setAttribute("memoList", memoList);

		return "list";
	}

	public String listRemind() throws Exception {
		String username = session.get("username");
		List<Memo> memoList = memoManager.getRemindMemoList(username);
		request.setAttribute("memoList", memoList);

		return "listRemind";

	}

	public String updateStatus() throws Exception {
		String memoId = request.getParameter("memoId");
		memoManager.updateMemoStatus(memoId, 1);
		return listRemind();
	}

	public List getMemoTypes() {
		return memoTypes;
	}

	public void setMemoTypes(List memoTypes) {
		this.memoTypes = memoTypes;
	}

	public MemoManager getMemoManager() {
		return memoManager;
	}

	public void setMemoManager(MemoManager memoManager) {
		this.memoManager = memoManager;
	}

	public MemoTypeManager getMemoTypeManager() {
		return memoTypeManager;
	}

	public void setMemoTypeManager(MemoTypeManager memoTypeManager) {
		this.memoTypeManager = memoTypeManager;
	}

	public MemoForm getMemo() {
		return memo;
	}

	public void setMemo(MemoForm memo) {
		this.memo = memo;
	}

}
