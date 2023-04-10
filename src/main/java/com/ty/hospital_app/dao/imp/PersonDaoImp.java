package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.Medorder;
import com.ty.hospital_app.dto.Person;

public class PersonDaoImp implements PersonDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sarfu");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction= entityManager.getTransaction();
	public Person savePerson(int eid, Person person) {
		Person person1=entityManager.find(Person.class,eid);
		if(person1!=null) {
		entityTransaction.begin();
		entityManager.persist(person1);
		entityTransaction.commit();
		return person1;
		}
		else {
			return null;
		}
	}

	public Person getPersonById(int pId) {
		Person person = entityManager.find(Person.class,pId);
		return person;
	}

	public boolean deletePersonById(int pId) {
		Person person = entityManager.find(Person.class, pId);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Person updatePersonById(int pId, Person person) {
		Person person1 = entityManager.find(Person.class, pId);
		if(person1!=null) {
			person1.setAddress(person.getAddress());
			person1.setAge(person.getAge());
			person1.setEncounter(person.getEncounter());
			person1.setGender(person.getGender());
			person1.setName(person.getName());
			person1.setPhno(person.getPhno() );
			entityTransaction.begin();
			entityManager.remove(person1);
			entityTransaction.commit();
			return person1;
		}
		return null;
	}

	public List<Person> getAllPerson() {
		Query query = entityManager.createQuery("select s from person s");
		List<Person> person = query.getResultList();
		return person;
	}

	public List<Person> getPersonByGender(String gender) {
		Query query = entityManager.createQuery("select s from person s where gender=?1");
		query.setParameter(1, gender);
		List<Person> person = query.getResultList();
		return person;
	}

	public List<Person> getPersonByAge(int age) {
		Query query = entityManager.createQuery("select s from person s where age=?1");
		query.setParameter(1, age);
		List<Person> person = query.getResultList();
		return person;
	}

	public List<Person> getPersonByphno(long phno) {
		Query query = entityManager.createQuery("select s from person s where phno=?1");
		query.setParameter(1, phno);
		List<Person> person = query.getResultList();
		return person;
	}

}
