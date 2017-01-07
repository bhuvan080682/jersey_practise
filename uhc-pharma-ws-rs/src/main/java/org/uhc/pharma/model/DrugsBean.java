package org.uhc.pharma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Drugs")
public class DrugsBean {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@NotNull
	@Column(name="Drug_Name")
	private String name;
	
	@NotNull
	@Column(name="Composition")
	private String composition;
	@NotNull
	@Column(name="Company")
	private String company;
	public DrugsBean(String name, String composition, String company) {
		super();
		this.name = name;
		this.composition = composition;
		this.company = company;
	}
	public DrugsBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	

}
