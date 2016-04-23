package hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Dao {

	
	public static <T> T getByName(String name, Class<T> clazz) {
		//通过名字查询类
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.eq("name", name));
		List<T> list = criteria.list();
		if (list.size() != 0) {
			session.close();
			return list.get(0);
		} else {
			session.close();
			return null;
		}
	}

	public static <T> List<T> queryByField(String field, String value, Class<T> clazz) {
		//根据字段查询类
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.eq(field, value));
		List list = criteria.list();
		session.close();
		return list;
	}

	public static void save(Object... tList) throws Exception {
		//同一事务下保存一个或多个对象
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		for (Object item : tList) {
			session.save(item);
		}

		transaction.commit();
		session.close();
	}

	public static <T> void delete(T t) throws Exception {
		//删除特定对象
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.delete(t);

		transaction.commit();
		session.close();
	}
}
