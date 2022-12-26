package com.Alexa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ministry_table")
public class MinistryVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ministry_id")
	private int ministryId;
	
	@Column(name="ministry_name")
	private String ministryName;
	
	@Column(name="ministry_description")
	private String ministryDescription;
	
	@Column(name="status")
	private boolean status=true;

	public int getMinistryId() {
		return ministryId;
	}

	public void setMinistryId(int ministryId) {
		this.ministryId = ministryId;
	}

	public String getMinistryName() {
		return ministryName;
	}

	public void setMinistryName(String ministryName) {
		this.ministryName = ministryName;
	}

	public String getMinistryDescription() {
		return ministryDescription;
	}

	public void setMinistryDescription(String ministryDescription) {
		this.ministryDescription = ministryDescription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
