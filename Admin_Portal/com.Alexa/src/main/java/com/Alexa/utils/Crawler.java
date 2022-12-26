package com.Alexa.utils;

public class Crawler {

	public static void main(String[] args) throws Exception{
	Ministry1 m1=new Ministry1("https://www.startupindia.gov.in/content/sih/en/government-schemes/SDI_.html");
	m1.getSchemeName();
	m1.getSchemeDescription();
	m1.getSchemeBenefits();
	m1.getSchemeECriteria();
	m1.getHowToApply();
	m1.getListOfDocs();
	}
}
