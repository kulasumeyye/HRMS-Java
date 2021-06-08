package kodlamaio.hrms.entities.concretes;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity

@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "city_name")
    @NotBlank(message = "cityName boş olamaz!")
    @NotNull(message = "cityName boş olamaz!")
    private String cityName;

    @OneToMany(mappedBy = "city")
    private List<JobAdvertisement> jobAdvertisements;

	public City() {
		super();
	}

	public City(int id,
			@NotBlank(message = "cityName boş olamaz!") @NotNull(message = "cityName boş olamaz!") String cityName,
			List<JobAdvertisement> jobAdvertisements) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.jobAdvertisements = jobAdvertisements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<JobAdvertisement> getJobAdvertisements() {
		return jobAdvertisements;
	}

	public void setJobAdvertisements(List<JobAdvertisement> jobAdvertisements) {
		this.jobAdvertisements = jobAdvertisements;
	}


}