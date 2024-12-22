package com.xworkz.xworkz_CommonModule_Sohita.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.xworkz_CommonModule_Sohita.dto.ModuleDTO;
import com.xworkz.xworkz_CommonModule_Sohita.entity.ModuleEntity;
import com.xworkz.xworkz_CommonModule_Sohita.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleRepository repository;
	
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public boolean validateAndSave(ModuleDTO modelDTO) {
		System.out.println("running validateAndSave in serviceImpl");

		String password = generateRandomPassword();
		
		ModuleEntity entity = new ModuleEntity();
		
		entity.setName(modelDTO.getName());
		entity.setEmail(modelDTO.getEmail());
		entity.setAlterEmail(modelDTO.getAlterEmail());
		entity.setPhoneNo(modelDTO.getPhoneNo());
		entity.setAlterPhoneNo(modelDTO.getAlterPhoneNo());
		entity.setLocation(modelDTO.getLocation());
		entity.setPassword(password);
		
		entity.setResetstatus(-1);
		System.out.println("Values"+entity.toString());
		boolean saved=repository.validateAndSave(entity);
		return true;
	}

	public String generateRandomPassword() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuilder password = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			int randomIndex = random.nextInt(characters.length());
			password.append(characters.charAt(randomIndex));
		}
      return password.toString();
	}

	
		
		@Override
	    public String getNameByEmailAndPassword(String email, String password) {
	        String name = repository.getNameByEmailAndPassword(email, password);
	        return name;
	    }

	    
		@Override
	    public Long countName(String name) {
	        Long count= repository.countName(name);
	        return count;
	    }

	   
		@Override
	    public Long countByEmail(String email) {
	        return repository.countByEmail(email);
	    }


	   
		@Override
	    public Long countByAlterEmail(String alterEmail) {
	        return repository.countByAlterEmail(alterEmail);
	    }

	   
		@Override
	    public Long countByPhoneNo(String phoneNo) {
	        return repository.countByPhoneNo(phoneNo);
	    }

	    
		@Override
	    public Long countByAlterPhoneNo(String alterPhoneNo) {
	        return repository.countByAlterPhoneNo(alterPhoneNo);
	    }

	    
		@Override
	    public Long countByLocation(String location) {
	        return repository.countByLocation(location);
	    }
		
		  @Override
		    public boolean resetPassword(String email, String oldPassword, String newPassword) {
		        ModuleEntity entity = repository.findByEmail(email);
		        if (entity != null) {
		            if (entity.getPassword().equals(oldPassword)) {
		                String encryptedPassword = passwordEncoder.encode(newPassword);

		                entity.setPassword(encryptedPassword);
		                entity.setResetstatus(0);

		                return repository.update(entity);
		            }
		        }
		        return false;
		    }


	
}
