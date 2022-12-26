package com.Alexa.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.Alexa.model.SchemeVO;

public class Ministry1 {

	private static String url;
	private static SchemeVO schemeVO;
	
	public Ministry1(String url,SchemeVO schemeVO) {
		this.url = url;
		this.schemeVO = schemeVO;
	}

	public static String getSchemeName() throws IOException {
		Document doc = Jsoup.connect(url).get();
		String s = doc.select(".page-title").text();
		System.out.println("Scheme Name=" + s);
		return s;
	}

	public static String getSchemeDescription() throws IOException {

		Document doc=Jsoup.connect(url).get();
		System.out.println("Scheme Description");
		Elements elements1=new Elements();
		elements1=doc.select(".page-desc");
		System.out.println(elements1.text());
		return elements1.text();		
	}

	public static String getSchemeECriteria() throws IOException {
		Document doc = Jsoup.connect(url).get();

		System.out.println("Scheme Eligibility Criteria");
		Elements elements = doc.select(".text.parbase");
		String text1  = "";
		int count = 0;
		for (Element e : elements) {
			 text1 = e.select("p").text();
			count++;
			if (count == 2) {
				System.out.println(text1);
				return text1;
			}
			
		}
		return text1;
	}

	public static String getSchemeBenefits() throws Exception {
		Document doc = Jsoup.connect(url).get();
		System.out.println("Scheme Benefits and Highlights");

		Element element = doc.select(".text.parbase").first();
		System.out.println(element.text());
		return (element.text());
	}

	public static String getHowToApply() throws Exception {
		Document doc = Jsoup.connect(url).get();

		System.out.println("How To Apply");
		Elements elements = doc.select(".text.parbase");

		int count = 0;
		String text1="";
		for (Element e : elements) {
			 text1 = e.select("p").text();
			count++;
			if (count == 3) {
				System.out.println(text1);
				return text1;
			}
		}
		return text1;

	}

	public static String getListOfDocs() {
		System.out.println("List Of Documents Required");
		return null;
	}

	public static SchemeVO getDetails() throws Exception{
		String schemeName = Ministry1.getSchemeName();	
		String schemeBenefits=Ministry1.getSchemeBenefits();
		String schemeECriteria = Ministry1.getSchemeECriteria();
		String schemeHowToApply=Ministry1.getHowToApply();	
		String schemeDescription=Ministry1.getSchemeDescription();
		String schemeListOfDocs=Ministry1.getListOfDocs();
		schemeVO.setSchemeName(schemeName);
		schemeVO.setSchemeBenefits(schemeBenefits);
		schemeVO.setSchemeECriteria(schemeECriteria);
		schemeVO.setSchemeHowToApply(schemeHowToApply);
		schemeVO.setSchemeDescription(schemeDescription);
		schemeVO.setSchemeListOfDocs(schemeListOfDocs);
		return schemeVO;
	
	}
	

}
