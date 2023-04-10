package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Hospital;

public class HospitalService {
	
	
	public void SaveHospital(Hospital hospital) {
	
		HospitalDaoImp daoimp = new HospitalDaoImp();
		Hospital hospital1 = daoimp.saveHospital(hospital);
		if(hospital1!=null) {
			
			System.out.println("data saved");
		}
		else {
			System.out.println("data not saved");
		}
		
	}
	
	
	public Hospital getHospitalById(int hid) {
		HospitalDaoImp daoimp = new HospitalDaoImp();
		Hospital hospital1 = daoimp.getHospitalById(hid);
		if(hospital1!=null) {
			return hospital1;
			
		}
		else {
			return null;
		}
		
	}
	
	public void deleteHospitalById(int hid) {
		
		HospitalDaoImp daoimp = new HospitalDaoImp();
		boolean flag = daoimp.deleteHospitalId(hid);
		if(flag) {
			System.out.println("data delete");
		}
		else {
			System.out.println("data not selected");
		}
	}
	
	public Hospital UpdateHospitalById(int hid,Hospital hospital) {
		HospitalDaoImp daoimp = new HospitalDaoImp();
		Hospital hospital1 =daoimp.UpdateHospitalById(hid, hospital);
		if(hospital1!=null) {
			return hospital1;
		}
		else {
			return null;
		}
		
		
	}

}
