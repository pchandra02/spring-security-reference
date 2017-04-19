package com.reference.spring.security.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="hotel")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hotel implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private String hotel_id;

	@Column(name="name")
	private String name;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;

	@Column(name="country")
	private String country;

	@Column(name="pincode")
	private String pincode;

	@Column(name="contact_no")
	private String contact_no;

	@Column(name="email")
	private String email;

	@Column(name="currency")
	private String currency;

	@Column(name="lat")
	private double lat;

	@Column(name="long")
	private double longitude;

	@Column(name="locality")
	private String locality;

	@Type(type = "date")
	@Column(name="date_created")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date_created;

	@Column(name="cm_id")
	private String cm_id;

	@Column(name="rm_id")
	private String rm_id;

	@Column(name="g_id")
	private String g_id;

	@Column(name="crs_id")
	private String crs_id;

	public Hotel()
	{
		super();
	}
	public Hotel(String name, String address, String city, String state, String country, String pincode, String contact_no, String email, String currency) {
		super();
		this.hotel_id = UUID.randomUUID().toString();
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.contact_no = contact_no;
		this.email = email;
		this.currency = currency;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getHotel_id() {return hotel_id;}
	public void setHotel_id(String hotel_id) {this.hotel_id = hotel_id;}
	public String getState() {return state;}
	public void setState(String state) {this.state = state;}
	public String getContact_no() {return contact_no;}
	public void setContact_no(String contact_no) {this.contact_no = contact_no;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getCurrency() {return currency;}
	public void setCurrency(String currency) {this.currency = currency;}
	public double getLat() {return lat;}
	public void setLat(double lat) {this.lat = lat;}
	public double getLongitude() {return longitude;}
	public void setLongitude(double longitude) {this.longitude = longitude;}
	public String getLocality() {return locality;}
	public void setLocality(String locality) {this.locality = locality;}
	public Date getDate_created() {return date_created;}
	public void setDate_created(Date date_created) {this.date_created = date_created;}
	public String getCm_id() {return cm_id;}
	public void setCm_id(String cm_id) {this.cm_id = cm_id;}
	public String getRm_id() {return rm_id;}
	public void setRm_id(String rm_id) {this.rm_id = rm_id;}
	public String getG_id() {return g_id;}
	public void setG_id(String g_id) {this.g_id = g_id;}
	public String getCrs_id() {return crs_id;}
	public void setCrs_id(String crs_id) {this.crs_id = crs_id;}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", country=" + country
				+ ", pincode=" + pincode;
	}
	
}

