package datamanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hibernate.Dao;
import model.Patient;

public class PatientManage {

	public static boolean checkRegister(String phone) {
		Map<String, String> condition = new HashMap();
		condition.put("account", phone);
		if (null != Dao.queryByMulti(condition, Patient.class)) {
			return true;
		} else {
			return false;
		}
	}

	public static Patient login(String account, String password) {
		Map<String, String> condition = new HashMap<>();
		condition.put("account", account);
		condition.put("password", password);
		List<Patient> patients  = Dao.queryByMulti(condition, Patient.class);
		if (patients.size() != 0) {
			return patients.get(0);
		} else {
			return null;
		}
	}

	// public Patient modify(String id){
	//
	// }
	public static void saveData(Patient p) {
		try {
			Dao.save(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
