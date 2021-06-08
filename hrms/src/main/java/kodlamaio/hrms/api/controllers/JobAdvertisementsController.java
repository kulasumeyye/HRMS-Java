package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdevertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdevertisementService) {
        super();
        this.jobAdevertisementService = jobAdevertisementService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdevertisementService.add(jobAdvertisement));
    }

    @GetMapping("/getByActive")
    public DataResult<List<JobAdvertisement>> getByActive(){
        return this.jobAdevertisementService.getByActive();
    }

    @GetMapping("/getByActiveOrderByCreatedDate")
    public DataResult<List<JobAdvertisement>> getByActiveOrderByCreatedDate(){
        return this.jobAdevertisementService.getByActiveOrderByCreatedDate();
    }

    @GetMapping("/getByActiveOrderByDeadline")
    public DataResult<List<JobAdvertisement>> getByActiveOrderByDeadline(){
        return this.jobAdevertisementService.getByActiveOrderByDeadline();
    }

    @GetMapping("/getByActiveAndEmployerId")
    public DataResult<List<JobAdvertisement>> getByActiveAndEmployerId(@RequestParam(name = "id") Integer id){
        return this.jobAdevertisementService.getByActiveAndEmployerId(id);
    }

    @GetMapping("/changedActivated")
    public Result changedActivated(int jobAdvertisementId){
        return this.jobAdevertisementService.changedActivated(jobAdvertisementId);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }

}
