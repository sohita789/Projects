package com.xworkz.xworkz_CommonModule_Sohita.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.xworkz_CommonModule_Sohita.dto.ModuleDTO;
import com.xworkz.xworkz_CommonModule_Sohita.entity.ModuleEntity;
import com.xworkz.xworkz_CommonModule_Sohita.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleRepository repository;

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
}
