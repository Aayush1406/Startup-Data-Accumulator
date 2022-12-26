package com.Alexa.service;

import java.util.List;

import com.Alexa.model.MinistryVO;

public interface MinistryService {

	public void insertMinistry(MinistryVO ministryVO);

	public List searchAllMinistry();

	public List searchMinistryId(MinistryVO ministryVO);

	
}
