package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	final private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        super();
        this.experienceDao = experienceDao;
    }


    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("Data eklendi");
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>( this.experienceDao.findAll(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Experience>> getAllOrderByEndDateDesc() {
        return new SuccessDataResult<List<Experience>>( this.experienceDao.getAllByOrderByEndDateDesc(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Experience>> getByEndDateIsNull() {
        return new SuccessDataResult<List<Experience>>( this.experienceDao.getByEndDateIsNull(),"Data Listelendi");
    }

    @Override
    public DataResult<List<Experience>> getByEndDateIsNotNullOrderByEndDateDesc() {
        return new SuccessDataResult<List<Experience>>( this.experienceDao.getByEndDateIsNotNullOrderByEndDateDesc(),"Data Listelendi");
    }

}
