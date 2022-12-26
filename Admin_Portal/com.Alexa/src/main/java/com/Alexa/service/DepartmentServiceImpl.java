package com.Alexa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alexa.dao.DepartmentDao;
import com.Alexa.model.DepartmentVO;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentDao departmentDao;
	
	@Override
	public void insertDepartment(DepartmentVO departmentVO) {
		departmentDao.insertDepartment(departmentVO);
		
	}

	@Override
	public List searchAllDepartment() {
		// TODO Auto-generated method stub
		return departmentDao.searchAllDepartment();
	}

	@Override
	public List searchDepartmentId(DepartmentVO departmentVO) {
		// TODO Auto-generated method stub
		return departmentDao.searchDepartmentId(departmentVO);
	}

}
