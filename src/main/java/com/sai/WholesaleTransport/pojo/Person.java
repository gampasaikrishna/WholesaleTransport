package com.sai.WholesaleTransport.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
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
import com.sai.WholesaleTransport.util.DateJsonDeserializer;
import com.sai.WholesaleTransport.util.DateJsonSerializer;

@Entity
@Table(name="person")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Person implements Serializable {

	private static final long serialVersionUID = -8617535957147426115L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;


	@OneToOne
	@JoinColumn(name="status_id")
	private Status  status;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String mailId;

	@Column(name="aleternate_email")
	private String aleternateMailId;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "alternate_mobile_number")
	private String alternateMobileNumber;
	
	@Column(name="debit_card_number")
	private String debitCardNumber;

	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name = "joining_date")
	private Date dateOfJoining;


	@OneToMany(mappedBy="customer")
	private List<Workitem> workitem;
	


	@OneToOne
	@JoinColumn(name="login_id")
	private Login login;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="person_servicetype",joinColumns={@JoinColumn(name="person_id")},inverseJoinColumns={@JoinColumn(name="servicetype_id")})
	private Set<Service> servicetype;

	@Column(name="image")
	private String image;
	
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	public Set<Service> getServicetype() {
		return servicetype;
	}

	public void setServicetype(Set<Service> servicetype) {
		this.servicetype = servicetype;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getAleternateMailId() {
		return aleternateMailId;
	}

	public void setAleternateMailId(String aleternateMailId) {
		this.aleternateMailId = aleternateMailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAlternateMobileNumber() {
		return alternateMobileNumber;
	}

	public void setAlternateMobileNumber(String alternateMobileNumber) {
		this.alternateMobileNumber = alternateMobileNumber;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	public String getDebitCardNumber() {
		return debitCardNumber;
	}

	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

	@JsonIgnore
	public List<Workitem> getWorkitem() {
		return workitem;
	}
	@JsonProperty
	public void setWorkitem(List<Workitem> workitem) {
		this.workitem = workitem;
	}

}
