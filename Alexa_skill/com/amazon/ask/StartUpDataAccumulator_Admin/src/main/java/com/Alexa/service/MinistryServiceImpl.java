package com.Alexa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alexa.dao.MinistryDao;
import com.Alexa.model.MinistryVO;

@Service
@Transactional
public class MinistryServiceImpl implements MinistryService {

	@Autowired
     MinistryDao ministryDao;
	
	
	@Override
	public void insertMinistry(MinistryVO ministryVO) {
		// TODO Auto-generated method stub
		ministryDao.insertMinistry(ministryVO);
	}


	@Override
	public List searchAllMinistry() {
		return ministryDao.searchAllMinistry();
		// TODO Auto-generated method stub
		
	}

	@Override
	public List searchMinistryId(MinistryVO ministryVO) {
		// TODO Auto-generated method stub
		return ministryDao.searchMinistryId(ministryVO);
	}

}
