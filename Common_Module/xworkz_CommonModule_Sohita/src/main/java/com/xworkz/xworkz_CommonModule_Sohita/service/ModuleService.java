package com.xworkz.xworkz_CommonModule_Sohita.service;

import com.xworkz.xworkz_CommonModule_Sohita.dto.ModuleDTO;

public interface ModuleService {

	 boolean validateAndSave(ModuleDTO modelDTO);

	Long countName(String name);

	Long countByEmail(String email);

	Long countByAlterEmail(String alterEmail);

	Long countByPhoneNo(String phoneNo);

	Long countByAlterPhoneNo(String alterPhoneNo);

	Long countByLocation(String location);

	String getNameByEmailAndPassword(String email, String password);
 
	 public boolean resetPassword(String email, String oldPassword, String newPassword);

}