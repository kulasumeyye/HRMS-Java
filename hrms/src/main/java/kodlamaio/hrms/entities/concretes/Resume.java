package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "resume")
public class Resume {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "image_Url")
    private String imageUrl;

    @Column(name = "github")
    private String github;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Education> educations;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Experience> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Skill> skills;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

	public Resume() {
		super();
	}

	public Resume(int id, String imageUrl, String github, String linkedin, String coverLetter, LocalDate createdDate,
			List<Education> educations, List<Experience> experiences, List<Language> languages, List<Skill> skills,
			JobSeeker jobSeeker) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.github = github;
		this.linkedin = linkedin;
		this.coverLetter = coverLetter;
		this.createdDate = createdDate;
		this.educations = educations;
		this.experiences = experiences;
		this.languages = languages;
		this.skills = skills;
		this.jobSeeker = jobSeeker;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

}
