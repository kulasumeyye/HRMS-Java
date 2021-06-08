package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		
		this.resumeDao = resumeDao;
	}

	@Override
	public DataResult<List<Resume>> getByJobSeeker_Id(int id) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByJobSeeker_Id(id),"Data Listelendi.");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"Data Listelendi.");
	}



	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Data eklendi");
	}

	@Override
	public DataResult<String> uploadPhoto(int id, String imageUrl) {
		// TODO Auto-generated method stub
		return null;
	}



	
}
