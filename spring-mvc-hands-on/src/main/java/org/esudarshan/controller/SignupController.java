package org.esudarshan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.esudarshan.model.Employee;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {

	@InitBinder
	public void customPropertyEditor(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd|MM|yyyy");
		webDataBinder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, false));
		// webDataBinder.registerCustomEditor(String.class, "name", new
		// EmployeeNamePropertyEditor());
	}

	@ModelAttribute
	public void addCommonModelAttributes(Model model) {
		model.addAttribute("title", "Spring MVC Hands-on");
	}

	@RequestMapping(value = "/signup")
	public ModelAndView signup() throws Exception {
		if (true)
			throw new Exception();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}

	@RequestMapping(value = "/signup-submit", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("emp") @Valid Employee employee, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();

		if (bindingResult.hasErrors()) {
			mv.setViewName("signup");
			return mv;
		}
		mv.setViewName("success");
		return mv;
	}

}
