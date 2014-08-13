package amigo.sshmemo.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MemoType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long type;
	
	private String name;
	
	private User user;
	
	private Date createTime;
	
	private Set<Memo> memos = new HashSet<Memo>(0);

	public long getType() {
		return type;
	}

	public void setType(long type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set<Memo> getMemos() {
		return memos;
	}

	public void setMemos(Set<Memo> memos) {
		this.memos = memos;
	}

}
