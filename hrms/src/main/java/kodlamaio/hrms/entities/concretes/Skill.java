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
import javax.validation.constraints.PastOrPresent;

import com.sun.istack.NotNull;


@Entity
@Table(name="skills")
public class Skill {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "skill_name")
	    @NotBlank(message = "skillName boş olamaz!")
	    @NotNull()
	    private String skillName;

	    @Column(name = "added_date")
	    @NotNull()
	    @NotBlank(message = "addedDate boş olamaz!")
	    @PastOrPresent
	    private LocalDate addedDate = LocalDate.now();

	    @ManyToOne
	    @JoinColumn(name = "resume_id")
	    private Resume resume;

		public Skill() {
			super();
		}

		public Skill(int id, @NotBlank(message = "skillName boş olamaz!") String skillName,
				@NotBlank(message = "addedDate boş olamaz!") @PastOrPresent LocalDate addedDate, Resume resume) {
			super();
			this.id = id;
			this.skillName = skillName;
			this.addedDate = addedDate;
			this.resume = resume;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getSkillName() {
			return skillName;
		}

		public void setSkillName(String skillName) {
			this.skillName = skillName;
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
