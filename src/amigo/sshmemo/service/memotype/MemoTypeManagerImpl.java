package amigo.sshmemo.service.memotype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import amigo.sshmemo.dao.BaseDao;
import amigo.sshmemo.dao.MemoType;
import amigo.sshmemo.dao.User;
import amigo.sshmemo.service.user.UserManager;

public class MemoTypeManagerImpl implements MemoTypeManager {
	private BaseDao dao = null;

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	private UserManager userManager = null;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public void saveMemoType(String name, String username) throws Exception {
		MemoType memoType = new MemoType();
		memoType.setName(name);
		memoType.setCreateTime(new Date());

		User user = userManager.getUser(username);
		memoType.setUser(user);

		dao.saveObject(memoType);

	}

	@Override
	public void updateMemoType(long type, String name) throws Exception {
		MemoType memoType = (MemoType) dao.getObject(MemoType.class, type);
		memoType.setName(name);
		dao.updateObject(memoType);

	}

	@Override
	public void deleteMemoType(String[] types) throws Exception {
		for (int i = 0; i < types.length; i++) {
			MemoType memoType = (MemoType) dao.getObject(MemoType.class, Long.parseLong(types[i]));
			if (memoType != null)
				dao.deleteObject(memoType);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemoType> getMemoTypeList(String username) throws Exception {
		List<MemoType> memoTypeList = null;
		String hql = null;
		if ("admin".equals(username)) {
			hql = "from MemoType";
			memoTypeList = dao.hqlQuery(hql, null);
		} else {
			List<String> paramList = new ArrayList<String>();
			hql = "from MemoType as obj where obj.user.username=?";
			paramList.add(username);
			memoTypeList = dao.hqlQuery(hql, paramList.toArray());
		}

		return memoTypeList;
	}

	@Override
	public MemoType getMemoType(long type) throws Exception {
		MemoType memoType = (MemoType) dao.getObject(MemoType.class, type);
		return memoType;
	}

}
