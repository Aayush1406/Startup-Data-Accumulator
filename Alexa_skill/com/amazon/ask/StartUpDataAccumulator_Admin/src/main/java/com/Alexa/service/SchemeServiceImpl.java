package com.Alexa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Alexa.dao.SchemeDao;
import com.Alexa.model.SchemeVO;
import com.Alexa.utils.Ministry1;
import com.Alexa.utils.Ministry10;
import com.Alexa.utils.Ministry2;
import com.Alexa.utils.Ministry3;
import com.Alexa.utils.Ministry4;
import com.Alexa.utils.Ministry5;
import com.Alexa.utils.Ministry6;
import com.Alexa.utils.Ministry7;
import com.Alexa.utils.Ministry8;
import com.Alexa.utils.Ministry9;

@Service
@Transactional
public class SchemeServiceImpl implements SchemeService {

	@Autowired
	private SchemeDao schemeDao;

	@Override
	public void insertScheme(SchemeVO schemeVO) {
		String ministryAlgorithm = schemeVO.getAlgorithmName();
		System.out.println("impl ministry algorithm======" + ministryAlgorithm);
		String schemeLink = schemeVO.getSchemeLink();

		SchemeVO schemeVO2 = new SchemeVO();

		System.out.println("BEFORE :: schemeVO" + schemeVO.getSchemeId());
		System.out.println("BEFORE :: schemeVO2" + schemeVO2.getSchemeId());

		try {
			switch (ministryAlgorithm) {
			case "Ministry1":
				Ministry1 m1 = new Ministry1(schemeLink, schemeVO);
				schemeVO2 = m1.getDetails();
				break;
			case "Ministry2":
				Ministry2 m2 = new Ministry2(schemeLink, schemeVO);
				schemeVO2 = m2.getDetails();
				break;
			case "Ministry3":
				Ministry3 m3 = new Ministry3(schemeLink, schemeVO);
				schemeVO2 = m3.getDetails();
				break;

			case "Ministry4":
				Ministry4 m4 = new Ministry4(schemeLink, schemeVO);
				schemeVO2 = m4.getDetails();
				break;
			case "Ministry5":
				Ministry5 m5 = new Ministry5(schemeLink, schemeVO);
				schemeVO2 = m5.getDetails();
				break;
			case "Ministry6":
				Ministry6 m6 = new Ministry6(schemeLink, schemeVO);
				schemeVO2 = m6.getDetails();
				break;
			case "Ministry7":
				Ministry7 m7 = new Ministry7(schemeLink, schemeVO);
				schemeVO2 = m7.getDetails();
				break;
			case "Ministry8":
				Ministry8 m8 = new Ministry8(schemeLink, schemeVO);
				schemeVO2 = m8.getDetails();
				break;
			case "Ministry9":
				Ministry9 m9 = new Ministry9(schemeLink, schemeVO);
				schemeVO2 = m9.getDetails();
				break;
			case "Ministry10":
				Ministry10 m10 = new Ministry10(schemeLink, schemeVO);
				schemeVO2 = m10.getDetails();
				break;
			}

			System.out.println("AFTER :: schemeVO" + schemeVO.getSchemeId());
			System.out.println("AFTER :: schemeVO2" + schemeVO2.getSchemeId());

			schemeVO2.setSchemeId(schemeVO.getSchemeId());
			schemeVO2.setAlgorithmName(schemeVO.getAlgorithmName());
			schemeVO2.setSchemeLink(schemeVO.getSchemeLink());
			schemeVO2.setMinistryVO(schemeVO.getMinistryVO());
			schemeVO2.setDepartmentVO(schemeVO.getDepartmentVO());
			this.schemeDao.insertScheme(schemeVO2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List searchAllScheme() {
		// TODO Auto-generated method stub
		return schemeDao.searchAllScheme();
	}

	@Override
	public List searchSchemeId(SchemeVO schemeVO) {
		// TODO Auto-generated method stub
		return schemeDao.searchSchemeId(schemeVO);
	}

}
