package com.Alexa.dao;

import java.util.List;

import com.Alexa.model.MinistryVO;

public interface MinistryDao {

	

	public void insertMinistry(MinistryVO ministryVO);

	public List searchAllMinistry();

	public List searchMinistryId(MinistryVO ministryVO);

	
}
