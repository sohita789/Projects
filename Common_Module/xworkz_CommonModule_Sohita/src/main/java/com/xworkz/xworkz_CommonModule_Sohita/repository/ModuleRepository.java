package com.xworkz.xworkz_CommonModule_Sohita.repository;

import com.xworkz.xworkz_CommonModule_Sohita.entity.ModuleEntity;

public interface ModuleRepository {

	public boolean validateAndSave(ModuleEntity entity);
	
	String getNameByEmailAndPassword(String email, String password);

	Long countName(String name);

	Long countByEmail(String email);

	Long countByAltEmail(String alterEmail);

	Long countByPhoneNo(String phoneNo);
	
	Long countByLocation(String location);

	 Long countByAlterPhoneNo(String alterPhoneNo);

	 Long countByAlterEmail(String alterEmail);
	 
	 boolean update(ModuleEntity entity);

	 ModuleEntity findByEmail(String email);


	
}


