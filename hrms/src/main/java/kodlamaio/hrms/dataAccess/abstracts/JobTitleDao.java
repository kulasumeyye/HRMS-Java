package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobTitle;

@Repository
public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
	
    @Query("select u from JobTitle u where lower(u.title) like lower(concat('%', :title,'%'))")
    List<JobTitle> getJobTitles(@Param("title") String title);

    List<JobTitle> getById(@Param("") int id);

    Optional<JobTitle> getOneByTitle(@Param("") String title);

    List<JobTitle> getByTitle(String title);
  }