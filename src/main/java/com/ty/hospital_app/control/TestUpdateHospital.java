package com.ty.hospital_app.control;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestUpdateHospital {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		HospitalService service= new HospitalService();
		hospital.setname("sarfuhelps");
		hospital.setWebsite("www.sarfuhwlps.com");
		service.UpdateHospitalById(2, hospital);
	}
}
