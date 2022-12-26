package com.Alexa.dao;

import java.util.List;

import com.Alexa.model.SchemeVO;

public interface SchemeDao {

	void insertScheme(SchemeVO schemeVO);

	List searchAllScheme();

	List searchSchemeId(SchemeVO schemeVO);

}
