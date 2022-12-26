package com.Alexa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Alexa.model.DepartmentVO;
import com.Alexa.service.DepartmentService;
import com.Alexa.service.MinistryService;

@Controller
public class DepartmentController {
	
	@Autowired
    DepartmentService departmentService;
	
	@Autowired
	MinistryService ministryService;
	
	
	@RequestMapping(value="admin/loadDepartment", method=RequestMethod.GET)
	public ModelAndView loadAddDepartment(){
		List ministryList = ministryService.searchAllMinistry();
		return new ModelAndView("admin/addDepartment","DepartmentVO",new DepartmentVO()).addObject("ministryList", ministryList);
	}		
	
	@RequestMapping(value="admin/insertDepartment",method=RequestMethod.POST)
	public ModelAndView insertDepartment(@ModelAttribute DepartmentVO departmentVO){		
		this.departmentService.insertDepartment(departmentVO);
		return new ModelAndView("redirect:/admin/loadDepartment");
	}
	
	@RequestMapping(value="admin/viewDepartment", method=RequestMethod.GET)
	public ModelAndView loadviewDepartment(DepartmentVO departmentVO){
		List departmentList=departmentService.searchAllDepartment();
		return new ModelAndView("admin/viewDepartment","departmentList",departmentList);
	}
	
	@RequestMapping(value="admin/deleteDepartment", method=RequestMethod.GET)
	public ModelAndView deleteDepartment(@RequestParam int departmentId, DepartmentVO departmentVO){
		departmentVO.setDepartmentId(departmentId);
		List departmentList = departmentService.searchDepartmentId(departmentVO);
				departmentVO=(DepartmentVO)departmentList.get(0);
				departmentVO.setStatus(false);
				departmentService.insertDepartment(departmentVO);
				return new ModelAndView("redirect:/admin/viewDepartment");
	}
	
	@RequestMapping(value="admin/editDepartment", method=RequestMethod.GET)
	public ModelAndView editDepartment(@RequestParam int departmentId, DepartmentVO departmentVO){
		departmentVO.setDepartmentId(departmentId);
		List departmentList = departmentService.searchDepartmentId(departmentVO);
		List ministryList = ministryService.searchAllMinistry();
		return new ModelAndView("admin/addDepartment","DepartmentVO",departmentList.get(0)).addObject("ministryList", ministryList);
	}
	
}
