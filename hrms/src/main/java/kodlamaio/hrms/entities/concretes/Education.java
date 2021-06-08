package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;


@Entity
@Table(name="educations")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    @NotNull(message = "schoolName boş olamaz!")
    @NotBlank(message = "schoolName boş olamaz!")
    private String schoolName;

    @Column(name = "department")
    private String department;

    @Column(name = "started_date")
    @NotNull(message = "startedDate boş olamaz!")
    @NotBlank(message = "startedDate boş olamaz!")
    @PastOrPresent
    private LocalDate startedDate;

    @Column(name = "end_date")
    @PastOrPresent
    private LocalDate endDate;

    @Column(name = "added_date")
    @NotNull(message = "addedDate boş olamaz!")
    @NotBlank(message = "addedDate boş olamaz!")
    @PastOrPresent
    private LocalDate addedDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

	public Education() {
		super();
	}

	public Education(int id,
			@NotNull(message = "schoolName boş olamaz!") @NotBlank(message = "schoolName boş olamaz!") String schoolName,
			String department,
			@NotNull(message = "startedDate boş olamaz!") @NotBlank(message = "startedDate boş olamaz!") @PastOrPresent LocalDate startedDate,
			@PastOrPresent LocalDate endDate,
			@NotNull(message = "addedDate boş olamaz!") @NotBlank(message = "addedDate boş olamaz!") @PastOrPresent LocalDate addedDate,
			Resume resume) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.department = department;
		this.startedDate = startedDate;
		this.endDate = endDate;
		this.addedDate = addedDate;
		this.resume = resume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getStartedDate() {
		return startedDate;
	}

	public void setStartedDate(LocalDate startedDate) {
		this.startedDate = startedDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

}