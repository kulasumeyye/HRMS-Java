package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="employers")
public class Employer extends User {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;

	@Column(name = "web_address")
	@NotBlank
	@NotNull
	private String webAddress;

	@Column(name = "phone_number")
	@NotBlank
	@NotNull
	//@Pattern(regexp = "^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$", message = "Telefon formatı hatalı...")
	@Size(min = 11, max = 11, message = "Telefon numarası 11 haneli olmalı")
	private String phoneNumber;

	@Column(name = "is_activated")
	private boolean isActivated ;

}
