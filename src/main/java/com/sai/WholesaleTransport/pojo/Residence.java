package com.sai.WholesaleTransport.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="residence")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Residence implements Serializable {
	
/*	private static final long serialVersionUID = -8617535957147426115L;
    
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	
	@Column(name="house_squarefeets")
	private String houseSquareFeets;
	
	@Column(name="kitchenRooms")
	private String kitchenRooms;
	
	@Column(name="hall_numbers")
	private String hallNumber;
	
	@Column(name="bath_rooms")
	private String bathRooms;
	
	@Column(name="bed_rooms")
	private String bedRoom;
	
	@Column(name="dining_hall")
	private String diningHall;
	
	@Column(name="balcony")
	private String balcony;
	
	@OneToOne
	@JoinColumn(name="category_id")
	private Category  category;
	
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
	public String getHouseSquareFeets() {
		return houseSquareFeets;
	}
	public void setHouseSquareFeets(String houseSquareFeets) {
		this.houseSquareFeets = houseSquareFeets;
	}
	public String getKitchenRooms() {
		return kitchenRooms;
	}
	public void setKitchenRooms(String kitchenRooms) {
		this.kitchenRooms = kitchenRooms;
	}
	public String getHallNumber() {
		return hallNumber;
	}
	public void setHallNumber(String hallNumber) {
		this.hallNumber = hallNumber;
	}
	public String getBathRooms() {
		return bathRooms;
	}
	public void setBathRooms(String bathRooms) {
		this.bathRooms = bathRooms;
	}
	public String getBedRoom() {
		return bedRoom;
	}
	public void setBedRoom(String bedRoom) {
		this.bedRoom = bedRoom;
	}
	public String getDiningHall() {
		return diningHall;
	}
	public void setDiningHall(String diningHall) {
		this.diningHall = diningHall;
	}
	public String getBalcony() {
		return balcony;
	}
	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	*/
	
}
