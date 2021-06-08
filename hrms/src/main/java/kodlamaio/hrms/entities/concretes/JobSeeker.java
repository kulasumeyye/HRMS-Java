package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;


@Entity
@Table(name = "job_seekers")
public class JobSeeker extends User {
    @Column(name = "first_name")
    @NotBlank(message = "firstName boş olamaz!")
    @NotNull(message = "firstName boş olamaz!")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "lastName boş olamaz!")
    @NotNull(message = "lastName boş olamaz!")
    private String lastName;

    @Column(name = "identification_number")
    @NotBlank(message = "idNumber boş olamaz!")
    @NotNull(message = "idNumber boş olamaz!")
    private String idNumber;

    @Column(name = "birth_date")
    @Past
    private Date birthDate;

	public JobSeeker() {
		super();
	}

	public JobSeeker(
			@NotBlank(message = "firstName boş olamaz!") @NotNull(message = "firstName boş olamaz!") String firstName,
			@NotBlank(message = "lastName boş olamaz!") @NotNull(message = "lastName boş olamaz!") String lastName,
			@NotBlank(message = "idNumber boş olamaz!") @NotNull(message = "idNumber boş olamaz!") String idNumber,
			@Past Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.birthDate = birthDate;
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

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}