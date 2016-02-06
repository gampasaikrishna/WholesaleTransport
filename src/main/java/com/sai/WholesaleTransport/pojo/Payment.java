package com.sai.WholesaleTransport.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.slokam.vserves.util.DateJsonDeserializer;
import com.slokam.vserves.util.DateJsonSerializer;

@Entity
@Table(name="payment")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Payment implements Serializable {

	private static final long serialVersionUID = -8617535957147426115L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="payment_type_id")
	private PaymentType Paymenttype;
	
	@JsonSerialize(using = DateJsonSerializer.class)
	@JsonDeserialize(using = DateJsonDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name="amount_paid")
	private String amountPaid;
	
	@Column(name="remarks")
	private String remarks;
	
	@OneToOne
	@JoinColumn(name="login_id")
	private Login login;
	
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public PaymentType getPaymenttype() {
		return Paymenttype;
	}

	public void setPaymenttype(PaymentType paymenttype) {
		Paymenttype = paymenttype;
	}

	
	
}
