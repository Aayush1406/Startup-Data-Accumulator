package com.Alexa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Alexa.model.MinistryVO;
import com.Alexa.service.MinistryService;

@Controller
public class MinistryController {
	
	@Autowired
    MinistryService ministryService;

	@RequestMapping(value="admin/loadMinistry",method=RequestMethod.GET)
	public ModelAndView loadAddMinistry(){
		
		return new ModelAndView("admin/addMinistry","MinistryVO",new MinistryVO());
	}
	
	@RequestMapping(value="admin/insertMinistry",method=RequestMethod.POST)
	public ModelAndView insertMinistry(@ModelAttribute MinistryVO ministryVO){		
		this.ministryService.insertMinistry(ministryVO);
		return new ModelAndView("admin/addMinistry","MinistryVO",new MinistryVO());
	}
	
	
	@RequestMapping(value="admin/viewMinistry",method=RequestMethod.GET)
	public ModelAndView viewMinistry(){
		List ministryList=this.ministryService.searchAllMinistry();
		return new ModelAndView("admin/viewMinistry","ministryList",ministryList);
	}
	
	@RequestMapping(value="admin/deleteMinistry", method=RequestMethod.GET)
	public ModelAndView deleteMinistry(@RequestParam int ministryId, MinistryVO ministryVO){
		System.out.println("inside delete method");
		ministryVO.setMinistryId(ministryId);
		List ministryList = ministryService.searchMinistryId(ministryVO);
		ministryVO = (MinistryVO)ministryList.get(0);
		ministryVO.setStatus(false);
		this.ministryService.insertMinistry(ministryVO);
		return new ModelAndView("redirect:/admin/viewMinistry");
	}
	
	@RequestMapping(value="admin/editMinistry", method=RequestMethod.GET)
	public ModelAndView editMinistry(@RequestParam int ministryId, MinistryVO ministryVO)	{
		ministryVO.setMinistryId(ministryId);
		List ministryList=this.ministryService.searchMinistryId(ministryVO);
		return new ModelAndView("admin/addMinistry","MinistryVO",ministryList.get(0));
	}
}
