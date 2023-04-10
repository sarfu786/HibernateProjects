package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.EncounterDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Hospital;

public class EncounterDaoImp implements EncounterDao {

	public Encounter saveEncounter(Encounter encounter) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		
		if(encounter!=null) {
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
		return encounter;
		}
		else {
			return null;
		}
		
	}

	public Encounter getEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class,eid);
		return encounter;
	}

	public boolean deleteEncounterById(int eid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public boolean updateEncounterById(int eid, Encounter encounter) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Encounter encounter1 = entityManager.find(Encounter.class, eid);
		if(encounter1!=null) {
			
			encounter1.setReason(encounter.getReason());
			encounter1.setDateofdischarge(encounter.getDateofjoin());
			encounter1.setDateofdischarge(encounter.getDateofdischarge());
			encounter1.setObs(encounter.getObs());
			encounter1.setPerson(encounter.getPerson());
			encounter1.setBranch(encounter.getBranch());
			encounter1.setOrder(encounter.getOrder());
			entityTransaction.begin();
			entityManager.merge(encounter1);
			entityTransaction.commit();

			return true;
		}
		else {
			return false;
		}
	}

	public List<Encounter> getAllencounter() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("select s from Encounter s");
		List<Encounter> encounter = query.getResultList();
		return encounter;
	}

}
