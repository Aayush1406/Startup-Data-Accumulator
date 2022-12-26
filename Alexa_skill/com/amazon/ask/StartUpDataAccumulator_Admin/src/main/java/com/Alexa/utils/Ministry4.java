package com.Alexa.utils;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.Alexa.model.SchemeVO;

public class Ministry4 {

	private static String url;
	private static SchemeVO schemeVO;
	
	public Ministry4(String url,SchemeVO schemeVO) {
		this.url = url;
		this.schemeVO = schemeVO;
	}
 
public static String getSchemeName() throws IOException{
	
	Document doc=Jsoup.connect(url).get();				
	String s=doc.select(".page-title").text();
	return s;
}

public static String getSchemeDescription() throws IOException {

	Document doc=Jsoup.connect(url).get();
	System.out.println("Scheme Description");
	Elements elements1=new Elements();
	elements1=doc.select(".page-desc");
	return elements1.text();		
}
	
public  static String getHowToApply() throws IOException{
	
	Document doc=Jsoup.connect(url).get();		
	
	
	System.out.println("How To Apply");
	Elements elements=doc.select(".text.parbase");
	 
	int count=0;
	String text1="";
	for(Element e:elements){
		text1=e.select("p").text();
		count++;
		if(count==3){
		System.out.println(text1);
		return text1;
		}
	}
	return text1;
}
	
	public  static String getSchemeBenefits() throws Exception{
		Document doc=Jsoup.connect(url).get();					
		System.out.println("Scheme Benefits and Highlights");
	
		Element element=doc.select(".text.parbase").first();
		return (element.text());
	}
	
	public  static String getSchemeECriteria() throws Exception{
		Document doc=Jsoup.connect(url).get();		
		
		
		System.out.println("Scheme Eligibility Criteria");
		Elements elements=doc.select(".text.parbase");
		 
		int count=0;
		String text1="";
		for(Element e:elements){
			text1=e.select("p").text();
			count++;
			if(count==2){
			System.out.println(text1);
			return text1;
			}
		}
	return text1;
	}
	
	public static String getListOfDocs() throws Exception{
		Document doc=Jsoup.connect(url).get();		
		
		
		System.out.println("Scheme List of Documents Required");
		Elements elements=doc.select(".text.parbase");
		 
		int count=0;
		String text1="";
		for(Element e:elements){
			text1=e.select("ul").text();
			count++;
			if(count==5){
			System.out.println(text1);
			}
		}
		return text1;
	
	}
	
	public static SchemeVO getDetails() throws Exception{
		String schemeName = Ministry4.getSchemeName();	
		String schemeBenefits=Ministry4.getSchemeBenefits();
		String schemeECriteria = Ministry4.getSchemeECriteria();
		String schemeHowToApply=Ministry4.getHowToApply();	
		String schemeDescription=Ministry4.getSchemeDescription();
		String schemeListOfDocs=Ministry4.getListOfDocs();
		schemeVO.setSchemeName(schemeName);
		schemeVO.setSchemeBenefits(schemeBenefits);
		schemeVO.setSchemeECriteria(schemeECriteria);
		schemeVO.setSchemeHowToApply(schemeHowToApply);
		schemeVO.setSchemeDescription(schemeDescription);
		schemeVO.setSchemeListOfDocs(schemeListOfDocs);
		return schemeVO;
	
	}

}
