package com.pack.techwarehouse.domain;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Owner 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ownerid;
	private String firstname, lastname;
	public Owner() 
	{
	}
	public Owner(String firstname, String lastname) 
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Laptop> laptops;
	public List<Laptop> getlaptops()
	{
		return laptops;
	}
	public void setlaptops(List<Laptop> laptops)
	{
		this.laptops = laptops;
	}
	public Long getOwnerid() 
	{
		return ownerid;
	}
	public String getFirstname() 
	{
		return firstname;
	}
	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}
	public String getLastname() 
	{
		return lastname;
	}
	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}
}