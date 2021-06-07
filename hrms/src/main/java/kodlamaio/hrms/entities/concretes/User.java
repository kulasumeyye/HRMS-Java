package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	private String password;
	
	@Transient
	@NotBlank
	@NotNull
	@JsonProperty(access = Access.WRITE_ONLY)
	private String passwordRepeat;
	
	
	public User() {
		
	}
	public User(int id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
