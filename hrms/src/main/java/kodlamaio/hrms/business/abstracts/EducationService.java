package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

public interface EducationService {
	 Result add(Education education);
	    DataResult<List<Education>> getAll();
	    DataResult<Education> get(int id);
	    DataResult<List<Education>> getAllOrderByEndDateDesc();
	    DataResult<List<Education>> getByEndDateIsNull();
	    DataResult<List<Education>> getByEndDateIsNotNullOrderByEndDateDesc();

}
