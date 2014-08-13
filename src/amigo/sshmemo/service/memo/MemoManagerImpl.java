package amigo.sshmemo.service.memo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import amigo.sshmemo.dao.BaseDao;
import amigo.sshmemo.dao.Memo;
import amigo.sshmemo.dao.MemoType;
import amigo.sshmemo.dao.User;

public class MemoManagerImpl implements MemoManager {

	private BaseDao dao;

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	@Override
	public void saveMemo(MemoForm memoForm) throws Exception {
		User user = (User) dao.getObject(User.class, memoForm.getUsername());

		MemoType memoType = (MemoType) dao.getObject(MemoType.class,
				Long.parseLong(memoForm.getType()));
		memoForm.setCreateTime(new Date());

		Memo memo = new Memo();
		BeanUtils.copyProperties(memo, memoForm);
		memo.setCreateTime(new Date());
		memo.setUser(user);
		memo.setMemoType(memoType);
		memo.setStatus(0);
		dao.saveObject(memo);

	}

	@Override
	public void updateMemo(MemoForm memoForm) throws Exception {
		Memo memo = (Memo) dao.getObject(Memo.class, memoForm.getMemoId());

		MemoType memoType = (MemoType) dao.getObject(MemoType.class,
				Long.parseLong(memoForm.getType()));

		memo.setDescription(memoForm.getDescription());
		memo.setMemoType(memoType);
		memo.setName(memoForm.getName());
		memo.setRemindTime(memoForm.getRemindTime());
		dao.updateObject(memo);

	}

	@Override
	public void deleteMemo(String[] memoIds) throws Exception {
		for (int i = 0; i < memoIds.length; i++) {
			long memoId = Long.parseLong(memoIds[i]);
			Memo memo = (Memo) dao.getObject(Memo.class, memoId);
			if (memo != null)
				dao.deleteObject(memo);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Memo> getMemoList(String username) throws Exception {
		List<Memo> memoList = null;
		String hql = null;
		if ("admin".equals(username)) {
			hql = "from Memo";
			memoList = dao.hqlQuery(hql, null);
		} else {
			List<String> paramList = new ArrayList<String>();
			hql = "from Memo as obj where obj.user.username=?";
			paramList.add(username);
			memoList = dao.hqlQuery(hql, paramList.toArray());
		}

		return memoList;
	}

	@Override
	public List<Memo> getRemindMemoList(String username) throws Exception {
		List paramList = new ArrayList();
		String hql = "from Memo as obj where obj.user.username=?"
				+ "and status = 0 and remindTime is not null and remindTime <?";
		paramList.add(username);
		paramList.add(new Date());
		List<Memo> memoList = dao.hqlQuery(hql, paramList.toArray());
		return memoList;
	}

	@Override
	public void updateMemoStatus(String memoId, int status) throws Exception {
		Memo memo = (Memo) dao.getObject(Memo.class, Long.parseLong(memoId));
		memo.setStatus(status);
		dao.updateObject(memo);

	}

	@Override
	public Memo getMemoById(long memoId) throws Exception {
		Memo memo = (Memo) dao.getObject(Memo.class, memoId);
		return memo;
	}

}
