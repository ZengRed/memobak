package amigo.sshmemo.service.user;

import java.util.List;

import amigo.sshmemo.dao.User;

public interface UserManager {
	public void saveUser(UserForm userForm) throws Exception;

	public void updateUser(UserForm userForm) throws Exception;

	public void deleteUser(String [] usernames) throws Exception;

	public List<User> getUserList() throws Exception;

	public boolean userLogin(String username, String password) throws Exception;

	public User getUser(String username) throws Exception;
}
