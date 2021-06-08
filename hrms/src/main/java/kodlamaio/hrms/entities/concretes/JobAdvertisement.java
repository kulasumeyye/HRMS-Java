package kodlamaio.hrms.entities.concretes;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;


@Entity
@Table(name = "job_advertisement")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "job_description")
    @NotBlank(message = "jobDescription boş olamaz!")
    @NotNull(message = "jobDescription boş olamaz!")
    private String jobDescription;

    @Column(name = "min_salary")
    @Positive
    private double minSalary;

    @Column(name = "max_salary")
    @Positive
    private double maxSalary;

    @Column(name = "number_of_open_position")
    @NotBlank(message = "numberOfOpenPosition boş olamaz!")
    @NotNull(message = "numberOfOpenPosition boş olamaz!")
    private int numberOfOpenPosition;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    private Employer employer;

    @ManyToOne
    @NotBlank(message = "jobTitle boş olamaz!")
    @NotNull(message = "jobTitle boş olamaz!")
    private JobTitle jobTitle;

    @ManyToOne
    @NotBlank(message = "city boş olamaz!")
    @NotNull(message = "city boş olamaz!")
    private City city;

	public JobAdvertisement() {
		super();
	}

	public JobAdvertisement(int id,
			@NotBlank(message = "jobDescription boş olamaz!") @NotNull(message = "jobDescription boş olamaz!") String jobDescription,
			@Positive double minSalary, @Positive double maxSalary,
			@NotBlank(message = "numberOfOpenPosition boş olamaz!") @NotNull(message = "numberOfOpenPosition boş olamaz!") int numberOfOpenPosition,
			LocalDate createdDate, LocalDate deadline, boolean isActive, Employer employer,
			@NotBlank(message = "jobTitle boş olamaz!") @NotNull(message = "jobTitle boş olamaz!") JobTitle jobTitle,
			@NotBlank(message = "city boş olamaz!") @NotNull(message = "city boş olamaz!") City city) {
		super();
		this.id = id;
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.numberOfOpenPosition = numberOfOpenPosition;
		this.createdDate = createdDate;
		this.deadline = deadline;
		this.isActive = isActive;
		this.employer = employer;
		this.jobTitle = jobTitle;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getNumberOfOpenPosition() {
		return numberOfOpenPosition;
	}

	public void setNumberOfOpenPosition(int numberOfOpenPosition) {
		this.numberOfOpenPosition = numberOfOpenPosition;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}