package com.ty.hospital_app.dao;

import java.util.List;


import com.ty.hospital_app.dto.Items;

public interface ItemDao {

	public Items saveItem(int mid,Items item);
	
	public Items getItemById(int iId);
	
	public boolean deleteItemById(int iId);
	
	public Items updateItem(int iId, Items item);
	
	public List<Items> getAllItems();
}
