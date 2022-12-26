package com.Alexa.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Alexa.model.MinistryVO;

@Repository
public class MinistryDaoImpl implements MinistryDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void insertMinistry(MinistryVO ministryVO) {
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(ministryVO);
		
	}

	@Override
	public List searchAllMinistry() {
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from MinistryVO where status=true");
		List ministryList=q.list();
		return ministryList;
		
	}


	@Override
	public List searchMinistryId(MinistryVO ministryVO) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query q = session.createQuery("from MinistryVO where id='"+ministryVO.getMinistryId()+"' ");
		List ministryList = q.list();
		return ministryList;
	}

}
