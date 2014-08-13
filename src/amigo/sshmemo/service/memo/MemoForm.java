package amigo.sshmemo.service.memo;

import java.util.Date;

import amigo.sshmemo.dao.MemoType;
import amigo.sshmemo.dao.User;

public class MemoForm {
	private long memoId;

	private String name;

	private String description;

	private Date remindTime;

	private Date createTime;

	private Integer status;

	private String username;

	private String type;

	private User user;

	private MemoType memoType;

	public long getMemoId() {
		return memoId;
	}

	public void setMemoId(long memoId) {
		this.memoId = memoId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}
