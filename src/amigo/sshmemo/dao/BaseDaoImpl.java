package amigo.sshmemo.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

	
	public void deleteObject(Object obj) throws HibernateException {
		this.getHibernateTemplate().delete(obj);
		getHibernateTemplate().flush();
	}

	@Override
	public void deleteObject(Class class1, Serializable serializable) throws HibernateException {
		this.getHibernateTemplate().delete(this.getObject(class1, serializable));
		getHibernateTemplate().flush();

	}

	@Override
	public void updateObject(Object ojb) throws HibernateException {
		this.getHibernateTemplate().update(ojb);
	}

	@Override
	public void saveObject(Object ojb) throws HibernateException {
		this.getHibernateTemplate().save(ojb);

	}

	@Override
	public Object getObject(Class class1, Serializable serializable) throws HibernateException {

		return this.getHibernateTemplate().get(class1, serializable);
	}

	@Override
	public List hqlQuery(String hsql) throws HibernateException {

		return query(hsql, null);
	}

	@Override
	public List hqlQuery(String hsql, Object obj) throws HibernateException {

		return query(hsql, obj);
	}

	private List query(final String sql, final Object obj) throws HibernateException {
		int count = 0;

		List queryList = (List) getHibernateTemplate().execute(
		// 创建匿名内部类
				new HibernateCallback() {
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session.createQuery(sql);
						if (obj != null) {
							if (obj instanceof Map) {
								String as[] = query.getNamedParameters();
								for (int k1 = 0; k1 < as.length; k1++) {
									query.setParameter(as[k1], ((Map) obj).get(as[k1]));
								}
							} else if (obj instanceof Object[]) {
								for (int k1 = 0; k1 < ((Object[]) obj).length; k1++) {
									query.setParameter(k1, ((Object[]) obj)[k1]);
								}
							} else {
								query.setParameter(0, obj);
							}

						}
						return query.list();
					}
				});

		return queryList;
	}

}
