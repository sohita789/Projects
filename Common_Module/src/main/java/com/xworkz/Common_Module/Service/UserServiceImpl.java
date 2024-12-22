package com.xworkz.Common_Module.Service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.Common_Module.DTO.UserDTO;
import com.xworkz.Common_Module.Repository.UserRepository;
import com.xworkz.Common_Module.entity.UserEntity;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
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
    public Long countByAltEmail(String altEmail) {
        return repository.countByAltEmail(altEmail);
    }

   
	@Override
    public Long countByPhone(String phone) {
        return repository.countByPhone(phone);
    }

    
	@Override
    public Long countByAltPhone(String altPhone) {
        return repository.countByAltPhone(altPhone);
    }

    
	@Override
    public Long countByLocation(String location) {
        return repository.countByLocation(location);
    }

    @Override
    public boolean validateAndSave(UserDTO dto) {

        if (dto.getName() == null || dto.getPhone() == null || dto.getAltPhone() == null|| dto.getLocation() == null)
        {
          return false;
        }
        String password = generateRandomPassword();
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setAltEmail(dto.getAltEmail());
        entity.setPhone(dto.getPhone());
        entity.setAltPhone(dto.getAltPhone());
        entity.setLocation(dto.getLocation());
        entity.setPassword(password);

        try {
            repository.save(entity);
            System.out.println("User details saved successfully: " + dto);
            return true;
        } catch (Exception e) {
            System.err.println("Error saving user details: " + e.getMessage());
            return false;
        }
    }
    public static String generateRandomPassword() {
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
    public boolean resetPassword(String email, String oldPassword, String newPassword) {
        UserEntity entity = repository.findByEmail(email);
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