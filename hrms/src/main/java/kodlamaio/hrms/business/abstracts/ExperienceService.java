package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);
    DataResult<List<Experience>> getAll();
    DataResult<List<Experience>> getAllOrderByEndDateDesc();
    DataResult<List<Experience>> getByEndDateIsNull();
    DataResult<List<Experience>> getByEndDateIsNotNullOrderByEndDateDesc();

}
