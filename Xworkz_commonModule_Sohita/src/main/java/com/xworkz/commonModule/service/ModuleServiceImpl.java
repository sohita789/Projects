package com.xworkz.commonModule.service;

import com.xworkz.commonModule.DTO.ModuleDTO;
import com.xworkz.commonModule.entity.ModuleEntity;
import com.xworkz.commonModule.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

@Service
public class ModuleServiceImpl implements ModuleService {
    String generatedPassword;
    @Autowired
    private ModuleRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean validateAndSave(ModuleDTO modelDTO) {
        System.out.println("validateAndSave in ModuleServiceImpl");
        StringBuilder sb = new StringBuilder();
        int length = 6;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

    //    AbstractAuditEntity abstractAuditEntity = new AbstractAuditEntity();
      //  abstractAuditEntity.setCreatedBy(abstractAuditEntity.getCreatedBy());
      //  abstractAuditEntity.setCreatedDate(abstractAuditEntity.getCreatedDate());
      //  abstractAuditEntity.setUpdatedBy(abstractAuditEntity.getUpdatedBy());
       // abstractAuditEntity.setUpdatedDate(abstractAuditEntity.getUpdatedDate());


        generatedPassword = sb.toString();
        System.out.println("Generated password: " + generatedPassword);

        ModuleEntity entity = new ModuleEntity();
        entity.setName(modelDTO.getName());
        entity.setEmail(modelDTO.getEmail());
        entity.setAlterEmail(modelDTO.getAlterEmail());
        entity.setPhoneNo(modelDTO.getPhoneNo());
        entity.setAlterPhoneNo(modelDTO.getAlterPhoneNo());
        entity.setLocation(modelDTO.getLocation());
        entity.setPassword(generatedPassword);
        entity.setResetstatus(-1);
        return repository.validateAndSave(entity);
    }



    public ModuleEntity login(String email, String password) {
        ModuleEntity entity = repository.onLogin(email, password);

        if (entity == null) {
            return null;
        }
        if (entity.getResetstatus() == -1) {
            return entity;
        }
        if (entity.getResetstatus() > 3) {
            System.out.println("account locked for email:" + email);
            return null;
        }
        if (entity.getPassword().equals(password)) {
            entity.setResetstatus(0);
            repository.update(entity);
            return entity;
        } else {
            int updatedCount = entity.getResetstatus() + 1;
            entity.setResetstatus(updatedCount);
            repository.update(entity);
            return null;
        }
    }

    @Override
    public long countName(String name) {
        long count = repository.countName(name);
        if (count > 0) {
            System.out.println("Name exists: " + name);
        } else {
            return 0;
        }
        return count;
    }

    @Override
    public long countByEmail(String email) {
        long count = repository.countByEmail(email);
        if (count > 0) {
            System.out.println("Email exist" + email);
            return count;
        } else {
            return 0;
        }
    }

    @Override
    public long countByPhoneNo(long phoneNo) {
        long count = repository.countByPhoneNo(phoneNo);
        if (count > 0) {
            System.out.println("Phone number exist" + phoneNo);
            return count;
        } else {
            return 0;
        }
    }

    @Override
    public long countByLocation(String location) {
        return 0;
    }

    @Override
    public long countByAlterEmail(String alterEmail) {
        long count = repository.countByAlterEmail(alterEmail);
        if (count > 0) {
            System.out.println("Alternate Email Aleady Exist " + alterEmail);
            return count;
        } else {
            return 0;
        }
    }

    @Override
    public long countByAlterPhoneNo(long alterPhoneNo) {
        long count = repository.countByAlterPhoneNo(alterPhoneNo);
        if (count > 0) {
            System.out.println("Alterphone aleady Exist " + alterPhoneNo);
            return count;
        } else

            return 0;
    }

    @Override
    public boolean resetPassword(String email, String oldPassword, String newPassword) {
        ModuleEntity entity = repository.findByEmail(email);
        System.out.println("service" + entity);
        if (entity != null) {
            if (entity.getPassword().equals(oldPassword)) {
                String encryptedPassword = passwordEncoder.encode(newPassword);
                entity.setPassword(encryptedPassword);
                entity.setResetstatus(0);
                System.out.println("service1" + entity);
                return repository.update(entity);
            }
        }
        return false;
    }

    public boolean saveEmail(String email) {
        final String name = "sohitapatil217@gmail.com";
        final String userPassword = "mgiz lnbj tfmj caww";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(name, userPassword);
            }
        });
        try {
            //Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(name));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Your Password");
            message.setText("Your generated password is: " + generatedPassword);

            //Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");
            return true;

        } catch (MessagingException e) {
           // Log the exception for debugging purposes
            System.err.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}



