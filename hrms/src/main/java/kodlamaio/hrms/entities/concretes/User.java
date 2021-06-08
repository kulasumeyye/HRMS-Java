package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import com.sun.istack.NotNull;


@Entity

@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email_address")
    @Email(message = "Hatali email!")
    @NotBlank(message = "Bu alan boş olamaz!")
    @NotNull
    private String email;

  

	@Column(name="password")
    @NotBlank(message = "Bu alan boş olamaz!")
    @NotNull
    private String password;
    
	  public User() {
		
	}

	public User(int id, @Email(message = "Hatali email!") @NotBlank(message = "Bu alan boş olamaz!") String email,
				@NotBlank(message = "Bu alan boş olamaz!") String password) {
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
