package amigo.sshmemo.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private int gender;

	private Date birthDate;

	private String tel;

	private String email;

	private Date createTime;
	
	private String description;
	
	private Set<Memo> memos = new HashSet<Memo>(0);
	
	private Set<MemoType> memoTypes = new HashSet<MemoType>(0);

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Memo> getMemos() {
		return memos;
	}

	public void setMemos(Set<Memo> memos) {
		this.memos = memos;
	}

	public Set<MemoType> getMemoTypes() {
		return memoTypes;
	}

	public void setMemoTypes(Set<MemoType> memoTypes) {
		this.memoTypes = memoTypes;
	}

}
