package com.Alexa.dao;

import java.util.List;

import com.Alexa.model.DepartmentVO;

public interface DepartmentDao {

	void insertDepartment(DepartmentVO departmentVO);

	List searchAllDepartment();

	List searchDepartmentId(DepartmentVO departmentVO);

}
