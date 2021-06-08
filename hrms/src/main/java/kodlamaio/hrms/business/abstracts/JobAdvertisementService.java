package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getByActive();
    DataResult<List<JobAdvertisement>> getByActiveOrderByCreatedDate();
    DataResult<List<JobAdvertisement>> getByActiveOrderByDeadline();
    DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(int userId);
    Result changedActivated(int jobAdvertisementId);

}
