package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Medorder;

public interface MedorderDao {

	public Medorder saveMedorder(int eid,Medorder medorder);
	
	public Medorder getMedorderById(int oid);
	
	public boolean deleteMedorderById(int oid, Medorder medorder);
	
	public Medorder updateMedorder(int oid, Medorder medorder);
	public List<Medorder> getAllMedoreder();
	
	public List<Medorder> getMedorderByDoctorname(String name);
	
}
