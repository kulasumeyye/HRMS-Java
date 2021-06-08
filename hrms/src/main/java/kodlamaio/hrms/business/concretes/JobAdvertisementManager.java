package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    final private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Data Eklendi");
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getByActive() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue(),"Data listelendi");
	}
	
	@Override
    public DataResult<List<JobAdvertisement>> getByActiveOrderByCreatedDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByCreatedDate(),"Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActiveOrderByDeadline() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByDeadline(),"Data listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(int userId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployerId(userId),"Data listelendi");
    }

    @Override
    public Result changedActivated(int jobAdvertisementId) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertisementId).get();
        if(jobAdvertisement.isActive()){
            jobAdvertisement.setActive(false);
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("İlan pasif hale getirildi");
        }
        jobAdvertisement.setActive(true);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İlan aktif hale getirildi");
    }


   

}