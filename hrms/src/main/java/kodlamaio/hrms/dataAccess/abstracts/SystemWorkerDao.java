package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.SystemWorker;

@Repository
public interface SystemWorkerDao extends JpaRepository<SystemWorker,Integer> {

}
