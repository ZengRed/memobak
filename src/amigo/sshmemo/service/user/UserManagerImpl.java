package amigo.sshmemo.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import amigo.sshmemo.dao.BaseDao;
import amigo.sshmemo.dao.User;

public class UserManagerImpl implements UserManager {
	private BaseDao dao = null;

	public void saveUser(UserForm form) throws Exception {

		User user = new User();
		BeanUtils.copyProperties(user, form);
		user.setCreateTime(new Date());

		dao.saveObject(user);

	}

	public void updateUser(UserForm userForm) throws Exception {
		User user = (User) dao.getObject(User.class, userForm.getUsername());
		user.setGender(userForm.getGender());
		user.setEmail(userForm.getEmail());
		user.setDescription(userForm.getDescription());
		user.setBirthDate(userForm.getBirthDate());
		dao.updateObject(user);
	}

	public void deleteUser(String[] usernames) throws Exception {
		for (int i = 0; i < usernames.length; i++) {
			User user = (User) dao.getObject(User.class, usernames[i]);
			if (user != null){
				dao.deleteObject(user);
			}
				
		}
	}

	public List<User> getUserList() throws Exception {
		List<User> userList = dao.hqlQuery("from User");
		return userList;
	}

	public boolean userLogin(String username, String password) throws Exception {
		String hql = "select count(*) from User as obj where obj.username=? and obj.password=?";

		List<String> paramList = new ArrayList<String>();
		paramList.add(username);
		paramList.add(password);

		int count = Integer.parseInt(dao.hqlQuery(hql, paramList.toArray()).get(0).toString());
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	public User getUser(String username) throws Exception {
		User user = (User) dao.getObject(User.class, username);
		return user;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

}
