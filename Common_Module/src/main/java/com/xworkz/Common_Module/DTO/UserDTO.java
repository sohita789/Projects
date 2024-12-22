package com.xworkz.Common_Module.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class UserDTO {
	
private String name;
private String email;
private String altEmail;
 private String phone;
private String altPhone;
private String location;
	
	
	public UserDTO() {
		
	}
	
	

}
 