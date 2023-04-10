package com.ty.hospital_app.dao;

import com.ty.hospital_app.dto.Hospital;

public interface HospitalDao {
	public Hospital saveHospital(Hospital hospital);
	
	public Hospital getHospitalById(int hid);
	
	public boolean deleteHospitalId(int hid);
	
	public Hospital UpdateHospitalById(int hid,Hospital hospital);

}


