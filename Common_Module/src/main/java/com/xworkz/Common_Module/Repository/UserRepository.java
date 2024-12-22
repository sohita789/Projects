package com.xworkz.Common_Module.Repository;

import com.xworkz.Common_Module.entity.UserEntity;


public interface UserRepository {

	boolean save(UserEntity entity);

	String getNameByEmailAndPassword(String email, String password);

	Long countName(String name);

	Long countByEmail(String email);

	Long countByAltEmail(String altEmail);

	Long countByPhone(String phone);

	Long countByAltPhone(String altPhone);

	Long countByLocation(String location);

	UserEntity findByEmail(String email);
	
	 boolean update(UserEntity entity);

	


}
