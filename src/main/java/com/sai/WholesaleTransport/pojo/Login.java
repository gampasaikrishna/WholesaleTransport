package com.sai.WholesaleTransport.pojo;

import java.util.Collection;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="login")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Login implements UserDetails {


	private static final long serialVersionUID = -8617535957147426115L;


	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="user_name")
	private String username;

	@Column(name="password")
	private String password;

	@OneToOne(mappedBy="login",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Address address;

	@OneToOne(mappedBy="login",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Person person;
	
	@OneToOne(mappedBy="login",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Residence residence;

	@OneToOne(mappedBy="login",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Payment payment;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="login_role",joinColumns={@JoinColumn(name="login_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
	private Set<Role> role;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public Person getPerson() {
		return person;
	}
	@JsonProperty
	public void setPerson(Person person) {
		this.person = person;
	}

	@JsonIgnore
	public Address getAddress() {
		return address;
	}
	@JsonProperty
	public void setAddress(Address address) {
		this.address = address;
	}


	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	@JsonIgnore
	public Residence getResidence() {
		return residence;
	}
	@JsonProperty
	public void setResidence(Residence residence) {
		this.residence = residence;
	}
	@JsonIgnore
	public Payment getPayment() {
		return payment;
	}
	@JsonProperty
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
@JsonIgnore
public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return role;
	}



@JsonIgnore
public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
@JsonIgnore
public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
@JsonIgnore
public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
@JsonIgnore
public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}