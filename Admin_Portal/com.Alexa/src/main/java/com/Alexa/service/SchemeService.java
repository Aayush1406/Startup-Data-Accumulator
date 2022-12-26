package com.Alexa.service;

import java.util.List;

import com.Alexa.model.SchemeVO;

public interface SchemeService {

	void insertScheme(SchemeVO schemeVO);

	List searchAllScheme();

	List searchSchemeId(SchemeVO schemeVO);

}
