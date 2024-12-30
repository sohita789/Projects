package com.xworkz.commonModule.service;

import com.xworkz.commonModule.DTO.ModuleDTO;
import com.xworkz.commonModule.entity.ModuleEntity;

public interface ModuleService {

    public boolean validateAndSave(ModuleDTO modelDTO);

    public ModuleEntity login(String email, String password);

    public  long countName(String name);

    public long countByEmail(String email);

    public long countByAlterEmail(String alterEmail);

    public long countByPhoneNo(long phoneNo);

    public long countByAlterPhoneNo(long alterPhoneNo);

    public long countByLocation(String location);

    public boolean resetPassword(String email, String oldPassword, String newPassword);

    public boolean saveEmail(String email);

}


