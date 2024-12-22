package com.xworkz.Common_Module.Service;

import com.xworkz.Common_Module.DTO.UserDTO;

public interface UserService {

	 boolean validateAndSave(UserDTO dto);

	String getNameByEmailAndPassword(String email, String password);

	Long countName(String name);

	Long countByEmail(String email);

	Long countByAltEmail(String altEmail);

	Long countByPhone(String phone);

	Long countByAltPhone(String altPhone);

	Long countByLocation(String location);

	 public boolean resetPassword(String email, String oldPassword, String newPassword);
	}

