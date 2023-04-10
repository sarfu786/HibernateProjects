package com.ty.hospital_app.control;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class GetDataById {

	public static void main(String[] args) {
		
		HospitalService Service = new HospitalService();
		Hospital hospital = Service.getHospitalById(2);
		System.out.println(hospital.getHid());
		System.out.println(hospital.getname());
		System.out.println(hospital.getWebsite());
		
		
	}
}
