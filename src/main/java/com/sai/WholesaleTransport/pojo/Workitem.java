package com.sai.WholesaleTransport.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.slokam.vserves.util.DateJsonDeserializer;
import com.slokam.vserves.util.DateJsonSerializer;

@Entity
@Table(name="workitem")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Workitem implements Serializable {

	private static final long serialVersionUID = -8617535957147426115L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="workitem_servicetype",joinColumns={@JoinColumn(name="workitem_id")},inverseJoinColumns={@JoinColumn(name="servicetype_id")})
	private Set<Service> serviceType;

	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name = "joining_date")
	private Date date;

	@OneToOne
	@JoinColumn(name="workitemstatus_id")
	private WorkitemStatus  workitemstatus;

	@Column(name="another_mobile_number")
	private String anotherMobileNo;

	@Column(name="itemsold")
	private String itemSold;

	@Column(name="amount_collection")
	private String amountCollected;

	@Column(name="remarks")
	private String remarks;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="assigned_employee_id")
	private Person assigned_employee;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Person customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	

	public Set<Service> getServiceType() {
		return serviceType;
	}

	public void setServiceType(Set<Service> serviceType) {
		this.serviceType = serviceType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public WorkitemStatus getWorkitemstatus() {
		return workitemstatus;
	}

	public void setWorkitemstatus(WorkitemStatus workitemstatus) {
		this.workitemstatus = workitemstatus;
	}

	public String getAnotherMobileNo() {
		return anotherMobileNo;
	}

	public void setAnotherMobileNo(String anotherMobileNo) {
		this.anotherMobileNo = anotherMobileNo;
	}

	public String getItemSold() {
		return itemSold;
	}

	public void setItemSold(String itemSold) {
		this.itemSold = itemSold;
	}

	public String getAmountCollected() {
		return amountCollected;
	}

	public void setAmountCollected(String amountCollected) {
		this.amountCollected = amountCollected;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@JsonIgnore
	public Person getAssigned_employee() {
		return assigned_employee;
	}
	@JsonProperty
	public void setAssigned_employee(Person assigned_employee) {
		this.assigned_employee = assigned_employee;
	}
	@JsonIgnore
	public Person getCustomer() {
		return customer;
	}
	@JsonProperty
	public void setCustomer(Person customer) {
		this.customer = customer;
	}





}
