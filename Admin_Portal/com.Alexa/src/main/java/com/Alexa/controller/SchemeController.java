
package com.Alexa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Alexa.model.SchemeVO;
import com.Alexa.service.DepartmentService;
import com.Alexa.service.MinistryService;
import com.Alexa.service.SchemeService;

@Controller
public class SchemeController {
	@Autowired
   private DepartmentService departmentService;
	@Autowired
   private MinistryService ministryService;
	@Autowired
	private SchemeService schemeService;
	
	@RequestMapping(value="admin/loadScheme", method=RequestMethod.GET)
	public ModelAndView loadAddScheme(){
		List departmentList=departmentService.searchAllDepartment();
		List ministryList=this.ministryService.searchAllMinistry();
		return new ModelAndView("admin/addScheme","SchemeVO",new SchemeVO()).addObject("departmentList",departmentList).addObject("ministryList",ministryList);
	}
	
	@RequestMapping(value="admin/insertScheme" , method=RequestMethod.POST)
	public ModelAndView insertScheme(@ModelAttribute SchemeVO schemeVO){
		
		this.schemeService.insertScheme(schemeVO);
		return new ModelAndView("redirect:/admin/loadScheme");
	}
	
	@RequestMapping(value="admin/viewScheme", method=RequestMethod.GET)
	public ModelAndView loadviewDepartment(){
		List schemeList=this.schemeService.searchAllScheme();
		return new ModelAndView("admin/viewScheme","schemeList",schemeList);
	}
	
	@RequestMapping(value="admin/deleteScheme" , method=RequestMethod.GET)
	public ModelAndView deleteScheme(SchemeVO schemeVO, @RequestParam int schemeId){
		schemeVO.setSchemeId(schemeId);
		List schemeList=schemeService.searchSchemeId(schemeVO);
		schemeVO=(SchemeVO)schemeList.get(0);
		schemeVO.setStatus(false);
		this.schemeService.insertScheme(schemeVO);
		return new ModelAndView("redirect:/admin/viewScheme");
		
	}
	
	@RequestMapping(value="admin/editScheme", method=RequestMethod.GET)
	public ModelAndView editScheme(SchemeVO schemeVO, @RequestParam int schemeId){
		schemeVO.setSchemeId(schemeId);
		List schemeList = schemeService.searchSchemeId(schemeVO);
		List departmentList=departmentService.searchAllDepartment();
		List ministryList=this.ministryService.searchAllMinistry();
		return new ModelAndView("admin/addScheme","SchemeVO",schemeList.get(0)).addObject("departmentList",departmentList).addObject("ministryList",ministryList);
		
	}
	
	
}
