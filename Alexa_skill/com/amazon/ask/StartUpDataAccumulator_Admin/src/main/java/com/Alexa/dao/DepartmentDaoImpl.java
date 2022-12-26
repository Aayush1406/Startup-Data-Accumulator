package com.Alexa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Alexa.model.DepartmentVO;

@Repository
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertDepartment(DepartmentVO departmentVO) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(departmentVO);
		
	}

	@Override
	public List searchAllDepartment() {
		Session session=sessionFactory.getCurrentSession();
		Query q= session.createQuery("from DepartmentVO where status=true");
		List departmentList=q.list();
		return departmentList;
		
	}

	@Override
	public List searchDepartmentId(DepartmentVO departmentVO) {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from DepartmentVO where id='"+departmentVO.getDepartmentId()+"' ");
		List departmentList = q.list();
		return departmentList;
	}

}
