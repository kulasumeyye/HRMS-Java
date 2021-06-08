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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;




@Entity
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_name")
    @NotNull(message = "languageName boş olamaz!")
    @NotBlank(message = "languageName boş olamaz!")
    private String languageName;

    @Column(name = "degree")
    @NotNull(message = "degree boş olamaz!")
    @NotBlank(message = "degree boş olamaz!")
    @DecimalMin(value = "1")
    @DecimalMax(value = "5")
    private Byte degree;

    @Column(name = "added_date")
    @NotNull(message = "addedDate boş olamaz!")
    @NotBlank(message = "addedDate boş olamaz!")
    @PastOrPresent
    private LocalDate addedDate = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

	public Language() {
		super();
	}

	public Language(int id,
			@NotNull(message = "languageName boş olamaz!") @NotBlank(message = "languageName boş olamaz!") String languageName,
			@NotNull(message = "degree boş olamaz!") @NotBlank(message = "degree boş olamaz!") @DecimalMin("1") @DecimalMax("5") Byte degree,
			@NotNull(message = "addedDate boş olamaz!") @NotBlank(message = "addedDate boş olamaz!") @PastOrPresent LocalDate addedDate,
			Resume resume) {
		super();
		this.id = id;
		this.languageName = languageName;
		this.degree = degree;
		this.addedDate = addedDate;
		this.resume = resume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Byte getDegree() {
		return degree;
	}

	public void setDegree(Byte degree) {
		this.degree = degree;
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