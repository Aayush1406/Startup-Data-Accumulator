package com.Alexa.utils;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ministry8 {

	static String url;
	 
	 public Ministry8(String url){
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
		
	public  static void getHowToApply() throws IOException{
		
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
		
		public  static void getSchemeBenefits() throws Exception{
			Document doc=Jsoup.connect(url).get();					
			System.out.println("Scheme Benefits and Highlights");
		
			Elements elements=doc.select(".text.parbase");
				int count=0;
				for(Element e:elements){
					String text1=e.select("ul").text();
					count++;
					if(count==1){
						System.out.println(text1);
						if(text1.equals("")){
							 text1=e.select("p").text();
							 System.out.println(text1);
						}
					}
				}
			
		}
		
		public  static void getSchemeECriteria() throws Exception{
			Document doc=Jsoup.connect(url).get();		
			
			
			System.out.println("Scheme Eligibility Criteria");
			Elements elements=doc.select(".text.parbase");
			 
			int count=0;
			for(Element e:elements){
				String text1=e.select("ul").text();
				count++;
				if(count==2){
				System.out.println(text1);
				if(text1.equals("")){
					text1=e.select("p").text();
					System.out.println(text1);
				}
				}
			}
		
		}
		
		public static void getListOfDocs() throws Exception{

			Document doc=Jsoup.connect(url).get();		
			
			
			System.out.println("get List of Documents");
			Elements elements=doc.select(".text.parbase");
			 
			int count=0;
			for(Element e:elements){
				String text1=e.select("ul").text();
				count++;
				if(count==4){
				System.out.println(text1);
				}
			}
		}
public static void main(String[] args) throws Exception{
			
			Ministry8.getSchemeName();
			Ministry8.getSchemeDescription();
			Ministry8.getSchemeBenefits();
			Ministry8.getSchemeECriteria();
			Ministry8.getHowToApply();
			Ministry8.getListOfDocs();
			}


}
