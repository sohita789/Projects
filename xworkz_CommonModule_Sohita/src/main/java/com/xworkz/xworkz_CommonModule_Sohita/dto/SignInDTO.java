package com.xworkz.xworkz_CommonModule_Sohita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SignInDTO {
	
	private int id;
	private String name;
	private String email;
	private long phoneNo;
	private String alterEmail;
	private long alterPhoneNo;
	private String location;
	
	public SignInDTO() {
		
	}}
	
	