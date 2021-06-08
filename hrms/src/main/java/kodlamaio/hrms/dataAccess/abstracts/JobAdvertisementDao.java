package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> getByIsActiveTrue();
    List<JobAdvertisement> getByIsActiveTrueOrderByCreatedDate();
    List<JobAdvertisement> getByIsActiveTrueOrderByDeadline();
    List<JobAdvertisement> getByIsActiveTrueAndEmployerId(int userId);
}
