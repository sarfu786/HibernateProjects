package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.ItemDao;
import com.ty.hospital_app.dto.Items;
import com.ty.hospital_app.dto.Medorder;


public class ItemDaoImp  implements ItemDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	public Items saveItem(int mid, Items item) {
		Items item1=entityManager.find(Items.class,mid);
		if(item1!=null) {
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
		return item1;
		}
		else {
			return null;
		}
	}

	public Items getItemById(int iId) {
		
		//		EntityTransaction entityTransaction = entityManager.getTransaction();
		Items item = entityManager.find(Items.class,iId);
		return item;
	}

	public boolean deleteItemById(int iId) {
		Items item = entityManager.find(Items.class, iId);
		if(item!=null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Items updateItem(int iId, Items item) {
		Items item1 = entityManager.find(Items.class, iId);
		if(item1!=null) {
		item1.setCost(item.getCost());
		item1.setName(item.getName());
		item1.setOrder(item.getOrder());
		item1.setQuantity(item.getQuantity());
		return item1;
		}
		else {
			return null;
		}
	}

	public List<Items> getAllItems() {
		Query query = entityManager.createQuery("select s from item s");
		List<Items> item = query.getResultList();
		return item;
	}

}
