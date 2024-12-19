package com.xworkz.xworkz_CommonModule_Sohita.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@Entity
@Table(name = "module_table")
public class ModuleEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long phoneNo;
	private String alterEmail;
	private long alterPhoneNo;
	private String location;
	private String password;
	
	public ModuleEntity() {

}
}