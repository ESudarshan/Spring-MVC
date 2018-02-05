package org.esudarshan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

	@RequestMapping(name = "add")
	public ModelAndView add(HttpServletRequest request) {

		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));

		int k = i + j;

		ModelAndView mv = new ModelAndView();
		mv.addObject("result", k);
		mv.setViewName("result");
		return mv;
	}

}
