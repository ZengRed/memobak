package amigo.sshmemo.dao;

import java.io.Serializable;
import java.util.Date;

public class Memo  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long memoId;
	
	private User user;
	
	private MemoType memoType;
	
	private String name;
	
	private String description;
	
	private Date remindTime;
	
	private Date createTime;
	
	private Integer status;

	public long getMemoId() {
		return memoId;
	}

	public void setMemoId(long memoId) {
		this.memoId = memoId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MemoType getMemoType() {
		return memoType;
	}

	public void setMemoType(MemoType memoType) {
		this.memoType = memoType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(Date remindTime) {
		this.remindTime = remindTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
