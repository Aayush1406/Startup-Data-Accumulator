package com.Alexa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	

	
	public String getAlgorithm() {
		return algorithmName;
	}

	public void setAlgorithm(String algorithm) {
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
