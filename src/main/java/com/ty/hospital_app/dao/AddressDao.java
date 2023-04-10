package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Address;

public interface AddressDao {
	
public Address saveAddress(int bid,Address address);
	
	public Address getAddressById(int aid);
	
	public boolean deleteAddressId(int aid);
	
	public Address UpdateAddressById(int bid,Address address);
	public List<Address> getAddressAll();
}
