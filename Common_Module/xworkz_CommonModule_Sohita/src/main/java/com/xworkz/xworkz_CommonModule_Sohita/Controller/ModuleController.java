package com.xworkz.xworkz_CommonModule_Sohita.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.xworkz_CommonModule_Sohita.dto.ModuleDTO;
import com.xworkz.xworkz_CommonModule_Sohita.service.ModuleService;


@Controller
@RequestMapping("/")
public class ModuleController {
	
	@Autowired
	ModuleService modelService;
	
	public ModuleController() {
		
	}
	 @PostMapping("/SignupServlet")
	    public String onSignup(ModuleDTO modelDTO, Model model) {
	        System.out.println("OnsignUp in ModuleController");
	        System.out.println(modelDTO);
	        boolean result=modelService.validateAndSave(modelDTO);
	        model.addAttribute("name","SignupSuccess");
	        return "Signup.jsp";
	        }
	    
    @PostMapping("/signin")
      public  String save(@RequestParam String email, @RequestParam String password, Model model)
      {
       String valid = modelService.getNameByEmailAndPassword(email,password);
      System.out.println("is it working"+valid);
      model.addAttribute("msg","SiginSuccess");
        return "Signin.jsp";
  }
    @PostMapping("/resetPassword")
        public String resetPassword(String email, String oldPassword, String newPassword, String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return "resetpassword";
        }

          boolean isValid = modelService.resetPassword(email, oldPassword, newPassword);
          if (isValid) {
            return "Signin.jsp";
         } else {
            return "resetpassword";
        }
    }
}