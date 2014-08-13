package junitTest;

import junit.framework.TestCase;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import amigo.sshmemo.action.user.UserAction;
import amigo.sshmemo.dao.BaseDaoImpl;
import amigo.sshmemo.service.user.UserForm;
import amigo.sshmemo.service.user.UserManagerImpl;

public class UserActionTest extends TestCase {

	public void testLogin() throws Exception {
		UserAction ua = new UserAction();
		UserManagerImpl um = new UserManagerImpl();
		ua.setUserManager(um);
		
		UserForm uf = new UserForm();
		uf.setUsername("zeng");
		uf.setPassword("zeng");
		ua.setUser(uf);
		
		BaseDaoImpl dao = new BaseDaoImpl();
		um.setDao(dao);
		
		assertEquals("login", ua.login());
	}

}
