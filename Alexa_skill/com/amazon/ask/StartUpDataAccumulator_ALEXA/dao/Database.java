package com.amazon.ask.startup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {

	static Connection cn=null;
	static final String HOSTNAME="jdbc:mysql://database-1.cm2qclded6tn.us-east-1.rds.amazonaws.com/startupdb";
	static final String USERNAME="aayush1234";
	static final String PASSWORD="aayush1234";
	
	public static Statement connection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(HOSTNAME,USERNAME,PASSWORD);
			Statement s = cn.createStatement();
			return s;
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public List getAllMinistry(){
		List ls = new ArrayList();
		
		try {
			Statement st = connection();
			
			ResultSet rs = st.executeQuery("SELECT * FROM ministry_table");
			
			while(rs.next()){
				String ministry_name = rs.getString("ministry_name");
				ls.add(ministry_name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	public List getMinistryDescription(String ministryName){
		
		List ls= new ArrayList();
		
		try{
			
			Statement s = connection();
			ResultSet r = s.executeQuery("select * from ministry_table where ministry_name = '"+ministryName+"' ");
			while(r.next()){
				String ministry_description = r.getString("ministry_description");
				ls.add(ministry_description);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return ls;
	}
	
	public void getDepartmentNameUnderMinistry(){
		List ls = new ArrayList();
		
		try{
			
			Statement s = connection();
			ResultSet r= s.executeQuery("select ministry_table.ministry_name , department_table.department_name,"
					+ " ministry_table.ministry_id, department_table.department_id "
					+ "from ministry_table inner join department_table on ministry_table.ministry_id=department_table.ministry_vo");
			
			while(r.next()){
				String ministryName = r.getString("ministry_name");
				String ministryId = r.getString("ministry_id");
				String departmentId = r.getString("department_id");
				String departmentName = r.getString("department_name");
				
			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List getAllDepartment(){
		List ls = new ArrayList();
		
		try{
			Statement s = connection();
			ResultSet r = s.executeQuery("select * from department_table");
			while(r.next()){
				String departmentName = r.getString("department_name");
				ls.add(departmentName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ls;
		
	}
	
	public List getDepartmentDescription(){
		List ls = new ArrayList();
		
		try{
			Statement s = connection();
			ResultSet r = s.executeQuery("select * from department_table");
			while(r.next()){
				String departmentDescription = r.getString("department_description");
				ls.add(departmentDescription);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ls;
		
	}

	public List getDepartmentDescription(String departmentName) {

		List ls= new ArrayList();
		
		try{
			
			Statement s = connection();
			ResultSet r = s.executeQuery("select * from department_table where department_name = '"+departmentName+"' ");
			while(r.next()){
				String department_description = r.getString("department_description");
				ls.add(department_description);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return ls;
		
	}
	
	public int getMinistryId(String ministryName){
		int id=0;
		try{
			Statement s = connection();
			ResultSet r = s.executeQuery("select ministry_id from ministry_table where ministry_name='"+ministryName+"' ");
		    while(r.next()){
		    	id=r.getInt("ministry_id");
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	public int getDepartmentId(String departmentName) {
		
		int id=0;
		try{
			Statement s = connection();
			ResultSet r = s.executeQuery("select department_id from department_table where department_name='"+departmentName+"' ");
		    while(r.next()){
		    	id=r.getInt("department_id");
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;

	}
	
	
	public List getAllMinistrySchemes(String ministryName) {
		List ls = new ArrayList();
		
		try{
			
			Statement s =connection();
			int id=getMinistryId(ministryName);
			ResultSet r2 =s.executeQuery("select scheme_name from scheme_table where Ministry_id='"+id+"' ");
			while(r2.next()){
				String schemeName=r2.getString("scheme_name");
				ls.add(schemeName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public List getAllDepartmentSchemes(String departmentName) {
	
		List ls = new ArrayList();
		
		try{
			
			Statement s =connection();
			int id=getDepartmentId(departmentName);
			ResultSet r2 =s.executeQuery("select scheme_name from scheme_table where department_id='"+id+"' ");
			while(r2.next()){
				String schemeName=r2.getString("scheme_name");
				ls.add(schemeName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ls;
		
	}

	public List getSchemeDescription(String schemeName) {
		
		List ls = new ArrayList();
		try{
			Statement s= connection();
			ResultSet r = s.executeQuery("select scheme_description from scheme_table where scheme_name='"+schemeName+"' ");
			while(r.next()){
				String schemeDescription = r.getString("scheme_description");
				ls.add(schemeDescription);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ls;
	}

	public List getSchemeEligibility(String schemeName) {
		
		List ls = new ArrayList();
		try{
			Statement s= connection();
			ResultSet r = s.executeQuery("select scheme_eligibility from scheme_table where scheme_name='"+schemeName+"' ");
			while(r.next()){
				String schemeEligibility = r.getString("scheme_eligibility");
				ls.add(schemeEligibility);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ls;
		
	}

	public List getSchemeBenefits(String schemeName) {
		
		List ls = new ArrayList();
		try{
			Statement s= connection();
			ResultSet r = s.executeQuery("select scheme_benefits from scheme_table where scheme_name='"+schemeName+"' ");
			while(r.next()){
				String schemeBenefits = r.getString("scheme_benefits");
				ls.add(schemeBenefits);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ls;

		
	}

	public List getSchemeHowToApply(String schemeName) {
		List ls = new ArrayList();
		try{
			Statement s= connection();
			ResultSet r = s.executeQuery("select scheme_howtoapply from scheme_table where scheme_name='"+schemeName+"' ");
			while(r.next()){
				String schemeHowToApply = r.getString("scheme_howtoapply");
				ls.add(schemeHowToApply);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ls;

		
	}

	public List getSchemeDocument(String schemeName) {
		List ls = new ArrayList();
		try{
			Statement s= connection();
			ResultSet r = s.executeQuery("select scheme_listofdocs from scheme_table where scheme_name='"+schemeName+"' ");
			while(r.next()){
				String schemeListOfDocs = r.getString("scheme_listofdocs");
				ls.add(schemeListOfDocs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ls;

		
		
	}


	
/*	public static void main(String[] args){
		Database d = new Database();
		List ls=d.getSchemeDocument("Samridhi Fund");
		String speech="";
		if(ls.size()>0){
			speech=(String)ls.get(0);
			System.out.println(speech);
		}
		
	} */
	

	
}
