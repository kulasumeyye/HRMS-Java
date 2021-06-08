package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeService {
	DataResult<List<Resume>> getByJobSeeker_Id(int id);
	DataResult<List<Resume>> getAll();
    Result add(Resume resume);
    DataResult<String> uploadPhoto(int id, String imageUrl);
}
