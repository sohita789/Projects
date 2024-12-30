package com.xworkz.commonModule.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

        @Data
        @NoArgsConstructor
     public class ModuleDTO {
     @NotNull
     @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters")
        private String name;

     @NotNull
     @Email
        private String email;

     @NotNull
     @Digits(integer = 10, fraction = 0, message = "Number should contain 10 digits")
        private long phoneNo;

     @NotNull
     @Email
        private String alterEmail;

     @NotNull
     @Digits(integer = 10, fraction = 0, message = "Number should contain 10 digits")
        private long alterPhoneNo;

     @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters")
     private String location;

}
