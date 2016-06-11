package hibernate;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.Doctor;
import model.Patient;
import model.Registration;
import model.TimeQuantum;

public class Dao {

	public static <T> List<T> getAll(Class<T> clazz) {
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(clazz);
		List<T> list = criteria.list();
		session.close();
		return list;
	}

	public static <T> T getById(String id, Class<T> clazz) {
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		T result = session.get(clazz, id);
		session.close();
		return result;
	}

	public static <T> T getByName(String name, Class<T> clazz) {
		// 通过名字查询类
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
		// 根据字段查询类
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.eq(field, value));
		List list = criteria.list();
		session.close();
		return list;
	}

	public static <T> List<T> queryByMulti(Map<String, String> condition, Class<T> clazz) {
		// 根据字段查询类
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(clazz);
		for (Entry<String, String> c : condition.entrySet()) {
			criteria.add(Restrictions.eq(c.getKey(), c.getValue()));
		}
		List list = criteria.list();
		session.close();
		return list;
	}
	/**
	 * 更新已有的对象的参数值
	 * @param objects
	 * @throws Exception
	 */
	public static void update(Object... objects) throws Exception {
		// 同一事务下更新一个或多个对象
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		for (Object item : objects) {
			session.update(item);
		}

		transaction.commit();
		session.close();
	}
	/**
	 * 保存创建的新的对象
	 * @param tList
	 * @throws Exception
	 */
	public static void save(Object... tList) throws Exception {
		// 同一事务下保存一个或多个对象
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
		// 删除特定对象
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.delete(t);

		transaction.commit();
		session.close();
	}
	/**
	 * 获取所有的挂号单（可以是医生，也可以是病人的）
	 * @param doctor 可空
	 * @param patient 可空
	 * @param timeQuantum
	 * @return
	 * @throws Exception
	 */
	public static List<Registration> getRegistrations(Doctor doctor, Patient patient, TimeQuantum timeQuantum)
			throws Exception {
		SessionFactory sessionFactory = Factory.get();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Registration.class);
		if (doctor != null) {
			System.out.println("doctor");
			criteria.add(Restrictions.eq("doctor", doctor));
		}

		if (patient != null) {
			criteria.add(Restrictions.eq("patient", patient));
		}

		if (timeQuantum != null) {
			criteria.add(Restrictions.eq("timeQuantum", timeQuantum));
		}

		List<Registration> result = criteria.list();
		session.close();
		return result;
	}
}
