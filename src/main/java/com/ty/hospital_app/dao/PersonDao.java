package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Person;

public interface PersonDao {

	public Person savePerson(int eid,Person person);
	
	public Person getPersonById(int pId);
	
	public boolean deletePersonById(int pId);
	
	public Person updatePersonById(int pId, Person person);
	
	public List<Person> getAllPerson();
	public List<Person> getPersonByGender(String gender);
	public List<Person> getPersonByAge(int age);
	public List<Person> getPersonByphno(long phno);	
}
