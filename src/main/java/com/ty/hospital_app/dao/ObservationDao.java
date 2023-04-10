package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Observation;

public interface ObservationDao {

	public Observation saveObservation(int eid,Observation observation);
	
	public Observation getObservationById(int oId);
	
	public boolean deleteObservationById(int oId);
	
	public Observation updateObservationById(int oId, Observation observation);
	public List<Observation> getAllObservation();
	public List<Observation> getObservationByDoctorname(String name);
	
	
	
}
