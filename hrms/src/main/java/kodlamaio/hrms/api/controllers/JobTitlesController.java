package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobTitle;

import java.util.List;

@RestController
@RequestMapping("/api/jobTitle/")
public class JobTitlesController {
    final private JobTitleService jobTitleService;

    public JobTitlesController(JobTitleService jobTitleService) {
        super();
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobTitle>> getAll(){
        return jobTitleService.getAll();
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DataResult<List<JobTitle>> getById(@PathVariable("id") Integer id){
        return jobTitleService.getById(id);
    }

    @RequestMapping(value = "/getByTitle/{title}", method = RequestMethod.GET)
    public DataResult<List<JobTitle>> getByTitle(@PathVariable("title") String title){
        return jobTitleService.getJobTitles(title);
    }

    @PostMapping("/add")
    public DataResult<JobTitle> add(JobTitle title){
        return this.jobTitleService.add(title);
    }
}
