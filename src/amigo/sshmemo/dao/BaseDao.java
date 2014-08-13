package amigo.sshmemo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface BaseDao {
	public void deleteObject(Object ojb) throws HibernateException;

	public void deleteObject(Class class1, Serializable serializable) throws HibernateException;

	public void updateObject(Object ojb) throws HibernateException;

	public void saveObject(Object ojb) throws HibernateException;

	public Object getObject(Class class1, Serializable serializable) throws HibernateException;

	public List hqlQuery(String hsql) throws HibernateException;
	
	public List hqlQuery(String hsql,Object obj) throws HibernateException;

}
