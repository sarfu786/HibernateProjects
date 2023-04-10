package com.ty.hospital_app.control;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestSaveHospital {

	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		HospitalService service = new HospitalService();
		hospital.setname("sachinDJ");
		hospital.setWebsite("www.sachxxx.com");
		service.SaveHospital(hospital);
	}
}
