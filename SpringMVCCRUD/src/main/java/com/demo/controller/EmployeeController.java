package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.dao.EmployeeDAO;
import com.demo.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	
	
	@RequestMapping("/")
	  public String getHome() {
		  return "home";
	  }
	
	@RequestMapping("register/form1")
	public String getRegisterForm(Model m) {
		Employee e = new Employee();
		m.addAttribute("cmd", e);
		return "register";
	}
	
	@RequestMapping(value = {"/register/save"}, method = RequestMethod.POST)
	public String registerSave(@ModelAttribute("cmd") Employee emp, RedirectAttributes redirectattributes) {
		System.out.println(emp);
		employeeDAO.save(emp);
		redirectattributes.addFlashAttribute("msg", "User Updated SuccessFully");
		return "redirect:/empList";
	}

	@RequestMapping(value = { "/register/update" }, method = RequestMethod.POST)
	public String registerUpdate(@ModelAttribute("cmd") Employee emp,
			RedirectAttributes redirectattributes) {
		employeeDAO.update(emp);
		redirectattributes.addFlashAttribute("msg", "Employee information Updated SuccessFully");
		return "redirect:/empList";
	}
	
	@RequestMapping("/empList")
	public String userList(Model m) {
		List<Employee> empList = employeeDAO.findAll();

		m.addAttribute("empList", empList);
		return "empList";
	}
	
	@RequestMapping("/edit")
	public String editUser(Model m, HttpServletRequest request) {
		String id = request.getParameter("id");
		
		Employee employee;
		employee = employeeDAO.findById(Integer.valueOf(id));
		m.addAttribute("cmd", employee);
		return "update";
	}
	
	@RequestMapping("/delete")
	public String deleteUser(Model m, HttpServletRequest request) {
		String id = request.getParameter("id");
		
		
		employeeDAO.delete(Integer.valueOf(id));
	
		return "redirect:/empList";
	}
	
	
}
