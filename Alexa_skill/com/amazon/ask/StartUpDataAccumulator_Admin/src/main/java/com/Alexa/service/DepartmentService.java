package com.Alexa.service;

import java.util.List;

import com.Alexa.model.DepartmentVO;

public interface DepartmentService {

	public void insertDepartment(DepartmentVO departmentVO);

	public List searchAllDepartment();

	public List searchDepartmentId(DepartmentVO departmentVO);

}
