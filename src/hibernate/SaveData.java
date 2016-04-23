package hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SaveData {
	private ArrayList<Object> objects;           //保存一次性存储的对象
	public SaveData(){
		objects=new ArrayList<>();
	}
	public void addData(Object o){               //添加要存储的对象，一次只能添加一个对象
		objects.add(o);
	}
	public void saveData(){                       //保存数据
		SessionFactory sessionFactory = hibernate.Factory.get();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
	    Iterator<Object> iterator=objects.iterator();
	    while(iterator.hasNext()){
	    	Object object=iterator.next();
	    	session.save(object);
	    }
		transaction.commit();
		session.close();
	}
}
