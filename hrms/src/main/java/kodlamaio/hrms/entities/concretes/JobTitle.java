package kodlamaio.hrms.entities.concretes;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "job_titles")
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    @NotBlank(message = "title boş olamaz!")
    @NotNull(message = "title boş olamaz!")
    private String title;

    @OneToMany(mappedBy = "jobTitle")
    private List<JobAdvertisement> jobAdvertisements;

	public JobTitle() {
		super();
	}

	public JobTitle(int id,
			@NotBlank(message = "title boş olamaz!") @NotNull(message = "title boş olamaz!") String title,
			List<JobAdvertisement> jobAdvertisements) {
		super();
		this.id = id;
		this.title = title;
		this.jobAdvertisements = jobAdvertisements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<JobAdvertisement> getJobAdvertisements() {
		return jobAdvertisements;
	}

	public void setJobAdvertisements(List<JobAdvertisement> jobAdvertisements) {
		this.jobAdvertisements = jobAdvertisements;
	}


}