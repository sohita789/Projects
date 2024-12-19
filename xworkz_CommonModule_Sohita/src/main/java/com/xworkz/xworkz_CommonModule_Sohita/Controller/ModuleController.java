package com.xworkz.xworkz_CommonModule_Sohita.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	    }

