package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.MedorderDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Medorder;

public class MedorderDaoImp implements MedorderDao {

	public Medorder saveMedorder(int eid, Medorder medorder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Medorder medorder1=entityManager.find(Medorder.class,eid);
		if(medorder1!=null) {
		entityTransaction.begin();
		entityManager.persist(medorder);
		entityTransaction.commit();
		return medorder1;
		}
		else {
			return null;
		}
	}

	public Medorder getMedorderById(int oid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//		EntityTransaction entityTransaction = entityManager.getTransaction();
		Medorder medorder = entityManager.find(Medorder.class,oid);
		return medorder;
	}

	public boolean deleteMedorderById(int oid, Medorder medorder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Medorder medorder1 = entityManager.find(Medorder.class, oid);
		if(medorder1!=null) {
			entityTransaction.begin();
			entityManager.remove(medorder);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Medorder updateMedorder(int oid, Medorder medorder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Medorder medorder1 = entityManager.find(Medorder.class, oid);
		if(medorder1!=null) {
			medorder1.setDname(medorder.getDname());
			medorder1.setEncounter(medorder.getEncounter());
			medorder1.setItems(medorder.getItems());
			medorder1.setOrderdate(medorder.getOrderdate());
			return medorder1;
		}
		else {
			return null;
		}
	}

	public List<Medorder> getAllMedoreder() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("select s from medorder s");
		List<Medorder> medorder = query.getResultList();
		return medorder;
	}

	public List<Medorder> getMedorderByDoctorname(String name) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("select s from Medorder s where dname=?1");
		query.setParameter(1, name);
		List<Medorder> medorder = query.getResultList();
		return medorder;
	}
	


}
