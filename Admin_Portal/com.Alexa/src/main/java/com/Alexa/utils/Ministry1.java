package com.Alexa.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Ministry1 {

	 static String url;
	 
	 public Ministry1(String url){
		 this.url=url;
		 
	 }
	 
	public static void getSchemeName() throws IOException{
		
		Document doc=Jsoup.connect(url).get();				
		String s=doc.select(".page-title").text();
		System.out.println("Scheme Name="+s);
		
	}

	public static void getSchemeDescription() throws IOException{
		
		Document doc=Jsoup.connect(url).get();
		System.out.println("Scheme Description");
		Elements elements1=new Elements();
		elements1=doc.select(".right-wrapper");
		elements1.forEach((e1)->{
			String text1=e1.select("p").text();
			String text2=e1.select("ul").text();
			System.out.println(text1);
			System.out.println(text2);
		});
		
		
	}		
		
public static  void getSchemeECriteria() throws IOException{
		
		Document doc=Jsoup.connect(url).get();		
		
		
		System.out.println("Scheme Eligibility Criteria");
		Elements elements=doc.select(".text.parbase");
		 
		int count=0;
		for(Element e:elements){
			String text1=e.select("p").text();
			count++;
			if(count==2){
			System.out.println(text1);
			}
		}
	}
		
		public static  void getSchemeBenefits() throws Exception{
			Document doc=Jsoup.connect(url).get();					
			System.out.println("Scheme Benefits and Highlights");
		
			Element element=doc.select(".text.parbase").first();
			System.out.println(element.text());
		}
		
		public static void getHowToApply() throws Exception{
			Document doc=Jsoup.connect(url).get();		
			
			
			System.out.println("How To Apply");
			Elements elements=doc.select(".text.parbase");
			 
			int count=0;
			for(Element e:elements){
				String text1=e.select("p").text();
				count++;
				if(count==3){
				System.out.println(text1);
				}
			}
		
		}
		public static void getListOfDocs(){
			System.out.println("List Of Documents Required");
		}
		
		public static void main(String[] args) throws Exception{
			
			Ministry1.getSchemeName();
			Ministry1.getSchemeDescription();
			Ministry1.getSchemeBenefits();
			Ministry1.getSchemeECriteria();
			Ministry1.getHowToApply();
			Ministry1.getListOfDocs();
			}
	
}
