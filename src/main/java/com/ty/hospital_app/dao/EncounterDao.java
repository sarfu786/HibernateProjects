package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Encounter;

public interface EncounterDao {

	public Encounter saveEncounter(Encounter encounter);
	
	public Encounter getEncounterById(int eid);
	
	public boolean deleteEncounterById(int eid);
	
	public boolean updateEncounterById(int eid, Encounter encounter);
	
	public List<Encounter> getAllencounter();
}
