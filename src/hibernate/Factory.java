package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * singleton class, to get the single instance of SessionFactory
 * 
 * @author host
 *
 */
public class Factory {
	private static SessionFactory sessionFactory;

	private Factory() {
	}

	public static SessionFactory get() {
		// double check,make sure user can get the same instance in different
		// thread
		if (sessionFactory == null) {
			synchronized (Factory.class) {
				if (sessionFactory == null) {
					Configuration configuration = new Configuration().configure();
					sessionFactory = configuration.buildSessionFactory();
				}
			}
		}
		return sessionFactory;
	}

}
