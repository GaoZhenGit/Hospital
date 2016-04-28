package datamanage;

import hibernate.Dao;

import java.util.List;


import model.Hospital;

public class HispitalManage {
	
	public static Hospital addHoptital(){
		Hospital hospital=new Hospital();
		return hospital;
	}
	public static List<Hospital> getHospitalByName(String name){
		return Dao.queryByField("name", name, Hospital.class);
	}
//	public Hospital modifyHospital(String id){
//		
//	}
	public void deleteHospital(String id){
		
	}
	
	
}
