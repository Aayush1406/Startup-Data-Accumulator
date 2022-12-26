package com.Alexa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.Alexa.utils.Ministry1;

@Entity
@Table(name="scheme_table")
public class SchemeVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int schemeId;
	
	@Column(name="scheme_link")
	private String schemeLink;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private DepartmentVO departmentVO;
	
	@ManyToOne
	@JoinColumn(name="Ministry_id")
	private MinistryVO ministryVO;

	@Column(name="status")
	private boolean status=true;
	
	@Column(name="algorithm")
	private String algorithmName;
	
	@Column(name="scheme_name")
	private String schemeName;
	
	@Column(name="scheme_description")
	private String schemeDescription;
	
	@Column(name="scheme_eligibility")
	private String schemeECriteria;
	
	@Column(name="Scheme_howtoapply")
	private String schemeHowToApply;
	
	@Column(name="scheme_benefits")
	private String schemeBenefits;
	
	@Column(name="scheme_listofdocs")
	private String schemeListOfDocs;
		
	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeDescription() {
		return schemeDescription;
	}

	public void setSchemeDescription(String schemeDescription) {
		this.schemeDescription = schemeDescription;
	}

	public String getSchemeECriteria() {
		return schemeECriteria;
	}

	public void setSchemeECriteria(String schemeECriteria) {
		this.schemeECriteria = schemeECriteria;
	}

	public String getSchemeHowToApply() {
		return schemeHowToApply;
	}

	public void setSchemeHowToApply(String schemehowtoapply) {
		this.schemeHowToApply = schemehowtoapply;
	}

	public String getSchemeBenefits() {
		return schemeBenefits;
	}

	public void setSchemeBenefits(String schemebenefits) {
		this.schemeBenefits = schemebenefits;
	}

	public String getSchemeListOfDocs() {
		return schemeListOfDocs;
	}

	public void setSchemeListOfDocs(String schemeListOfDocs) {
		this.schemeListOfDocs = schemeListOfDocs;
	}

	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithm) {
		this.algorithmName = algorithm;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeLink() {
		return schemeLink;
	}

	public void setSchemeLink(String schemeLink) {
		this.schemeLink = schemeLink;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}

	public MinistryVO getMinistryVO() {
		return ministryVO;
	}

	public void setMinistryVO(MinistryVO ministryVO) {
		this.ministryVO = ministryVO;
	}
	
}
