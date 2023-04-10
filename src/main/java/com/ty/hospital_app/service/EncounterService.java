package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.EncounterDaoImp;
import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Hospital;

public class EncounterService {

	public void SaveEncounter(Encounter encounter) {
		
		EncounterDaoImp daoimp = new EncounterDaoImp();
		Encounter encounter1 = daoimp.saveEncounter(encounter);
		if(encounter1!=null) {
			
			System.out.println("data saved");
		}
		else {
			System.out.println("data not saved");
		}
	
}
}
