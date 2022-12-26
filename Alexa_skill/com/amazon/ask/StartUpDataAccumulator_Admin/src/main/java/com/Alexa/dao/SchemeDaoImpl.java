package com.Alexa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Alexa.model.SchemeVO;

@Repository
public class SchemeDaoImpl implements SchemeDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertScheme(SchemeVO schemeVO) {
		Session session= sessionFactory.getCurrentSession();
		session.saveOrUpdate(schemeVO);
	}

	@Override
	public List searchAllScheme() {
		Session session = sessionFactory.getCurrentSession();
		Query q=session.createQuery("from SchemeVO where status=true");
		List schemeList=q.list();
		return schemeList;
		
	}

	@Override
	public List searchSchemeId(SchemeVO schemeVO) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from SchemeVO where id='"+schemeVO.getSchemeId()+"' ");
		List schemeList = q.list();
		
		return schemeList;
	}

}
