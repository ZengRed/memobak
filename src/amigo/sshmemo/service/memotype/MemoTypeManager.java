package amigo.sshmemo.service.memotype;

import java.util.List;

import amigo.sshmemo.dao.MemoType;

public interface MemoTypeManager {
	public void saveMemoType(String name,String username) throws Exception;

	public void updateMemoType(long type,String name) throws Exception;

	public void deleteMemoType(String [] types) throws Exception;

	public List<MemoType> getMemoTypeList(String username) throws Exception;

	public MemoType getMemoType(long type) throws Exception;
}
