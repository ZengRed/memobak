package amigo.sshmemo.service.memo;

import java.util.List;

import amigo.sshmemo.dao.Memo;

public interface MemoManager {
	public void saveMemo(MemoForm memoForm) throws Exception;

	public void updateMemo(MemoForm memoForm) throws Exception;

	public void deleteMemo(String[] memoIds) throws Exception;

	public List<Memo> getMemoList(String username) throws Exception;

	public List<Memo> getRemindMemoList(String username) throws Exception;

	public void updateMemoStatus(String memoId, int status) throws Exception;

	public Memo getMemoById(long memoId) throws Exception;
	

}
