package com.sai.WholesaleTransport.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="address")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class ShopAddress  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="Shop_Name")
	private String ShopName;
	
	@Column(name="landmark1")
	private String landMark1;

	@Column(name="landmark2")
	private String  landMark2;

	@Column(name="area_name")
	private String areaName;
	
	
	@OneToOne
	@JoinColumn(name="shop_address")
	private Address address;

	@OneToOne
	@JoinColumn(name="city_id")
	private City city;

	@OneToOne
	@JoinColumn(name="state_id")
	private State state;

	@OneToOne
	@JoinColumn(name="country_id")
	private Country country;

	@Column(name="pincode")
	private String pinCode;

	@OneToOne
	@JoinColumn(name="login_id")
	private Login login;
	
	

}
