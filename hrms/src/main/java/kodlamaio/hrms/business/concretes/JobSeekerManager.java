package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
    final private JobSeekerDao jobSeekerDao;
    final private UserDao userDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao) {
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.userDao = userDao;
    }




	@Override
	public DataResult<List<JobSeeker>> getAll() {
		 return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Data Listelendi");
	}


	@Override
	public Result add(JobSeeker jobSeeker) {
		if(this.userDao.getByEmail(jobSeeker.getEmail()).stream().count() == 0 && this.jobSeekerDao.getByIdNumber(jobSeeker.getIdNumber()).stream().count() == 0){
            this.jobSeekerDao.save(jobSeeker);
            return new SuccessResult("Data eklendi");
        }else return new ErrorResult("Data eklenemedi");
	}
}