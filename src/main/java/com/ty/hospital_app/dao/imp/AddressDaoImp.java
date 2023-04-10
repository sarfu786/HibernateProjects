package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.AddressDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Hospital;

public class AddressDaoImp implements AddressDao {

	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction= entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class,bid);
		if(branch!=null) {
		entityTransaction.begin();
		entityManager.persist(address);
		entityTransaction.commit();
		return address;
		}
		else {
			return null;
		}
	}

	public Address getAddressById(int aid) {
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//		EntityTransaction entityTransaction = entityManager.getTransaction();
		Address address = entityManager.find(Address.class,aid);
		return address;
	}

	public boolean deleteAddressId(int aid) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Address address = entityManager.find(Address.class, aid);
		if(address!=null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Address UpdateAddressById(int bid, Address address) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Address address1 = entityManager.find(Address.class, bid);
		if(address1!=null) {
			address1.setBranch(address.getBranch());
			address1.setCountry(address.getCountry());
			address1.setState(address.getState());
			address1.setStreet(address.getStreet());
			return address1;
		}
		else {
			return null;
		}
		
	}

	public List<Address> getAddressAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("select s from Address s");
		List<Address> address = query.getResultList();
		return address;
	}

}
