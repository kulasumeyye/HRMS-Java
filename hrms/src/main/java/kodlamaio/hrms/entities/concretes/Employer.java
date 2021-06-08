package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity

@Table(name = "employers")
public class Employer extends User {
    @Column(name = "company_name")
    @NotBlank(message = "companyName boş olamaz!")
    @NotNull(message = "companyName boş olamaz!")
    private String companyName;

    @Column(name = "web_address")
    @NotBlank(message = "webAddress boş olamaz!")
    @NotNull(message = "webAddress boş olamaz!")
    private String webAddress;

    @Column(name = "phone_number")
    @NotBlank(message = "phoneNumber boş olamaz!")
    @NotNull(message = "phoneNumber boş olamaz!")
    private String phoneNumber;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

	public Employer() {
		super();
	}

	public Employer(
			@NotBlank(message = "companyName boş olamaz!") @NotNull(message = "companyName boş olamaz!") String companyName,
			@NotBlank(message = "webAddress boş olamaz!") @NotNull(message = "webAddress boş olamaz!") String webAddress,
			@NotBlank(message = "phoneNumber boş olamaz!") @NotNull(message = "phoneNumber boş olamaz!") String phoneNumber,
			List<JobAdvertisement> jobAdvertisements) {
		super();
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
		this.jobAdvertisements = jobAdvertisements;
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

	public List<JobAdvertisement> getJobAdvertisements() {
		return jobAdvertisements;
	}

	public void setJobAdvertisements(List<JobAdvertisement> jobAdvertisements) {
		this.jobAdvertisements = jobAdvertisements;
	}
}