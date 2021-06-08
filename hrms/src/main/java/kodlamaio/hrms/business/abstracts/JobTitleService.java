package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleService {

	    DataResult<JobTitle> add(JobTitle title);
	    DataResult<List<JobTitle>> getAll();
	    DataResult<List<JobTitle>> getById(int id);
	    DataResult<List<JobTitle>> getJobTitles(String title);
}
