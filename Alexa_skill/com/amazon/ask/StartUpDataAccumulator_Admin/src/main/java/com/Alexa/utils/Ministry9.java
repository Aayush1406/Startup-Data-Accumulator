package com.Alexa.utils;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.Alexa.model.SchemeVO;

public class Ministry9 {

	private static String url;
	private static SchemeVO schemeVO;
	
	public Ministry9(String url,SchemeVO schemeVO) {
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
		
			Elements elements=doc.select(".text.parbase");
				int count=0;
				String text1="";
				for(Element e:elements){
					text1=e.select("ul").text();
					count++;
					if(count==1){
						System.out.println(text1);
						if(text1.equals("")){
							 text1=e.select("p").text();
							 System.out.println(text1);
							 return text1;
						}
						return text1;
					}
				}
			return text1;
		}
		
		public  static String getSchemeECriteria() throws Exception{
			Document doc=Jsoup.connect(url).get();		
			
			
			System.out.println("Scheme Eligibility Criteria");
			Elements elements=doc.select(".text.parbase");
			 
			int count=0;
			String text1="";
			for(Element e:elements){
				text1=e.select("ul").text();
				count++;
				if(count==2){
				System.out.println(text1);
				if(text1.equals("")){
					text1=e.select("p").text();
					System.out.println(text1);
					return text1;
				}
				
				}
			}
		return text1;
		}
		
		public static String getListOfDocs() throws Exception{

			Document doc=Jsoup.connect(url).get();		
			
			
			System.out.println("get List of Documents");
			Elements elements=doc.select(".text.parbase");
			 
			int count=0;
			String text1="";
			for(Element e:elements){
				text1=e.select("ul").text();
				count++;
				if(count==4){
				System.out.println(text1);
				return text1;
				}
			}
			return text1;
		}
		public static SchemeVO getDetails() throws Exception{
			String schemeName = Ministry9.getSchemeName();	
			String schemeBenefits=Ministry9.getSchemeBenefits();
			String schemeECriteria = Ministry9.getSchemeECriteria();
			String schemeHowToApply=Ministry9.getHowToApply();	
			String schemeDescription=Ministry9.getSchemeDescription();
			String schemeListOfDocs=Ministry9.getListOfDocs();
			schemeVO.setSchemeName(schemeName);
			schemeVO.setSchemeBenefits(schemeBenefits);
			schemeVO.setSchemeECriteria(schemeECriteria);
			schemeVO.setSchemeHowToApply(schemeHowToApply);
			schemeVO.setSchemeDescription(schemeDescription);
			schemeVO.setSchemeListOfDocs(schemeListOfDocs);
			return schemeVO;
		
		}

}
