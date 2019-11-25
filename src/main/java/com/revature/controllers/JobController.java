package com.revature.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.repository.JobRepository;
import com.revature.service.JobService;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/jobs")
public class JobController{
    @Autowired
    private JobService js;
    
    /**
     * Add jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
     @PostMapping("/insertJob")
        public boolean insertJobInfo(@RequestBody Job b) {
            return js.insertJobInfo(b);
        }
     /**
      * update jobs to the database
      * 
      * @return String confirming successful or unsuccessful entry
      * @author	william liederer
      */
      @PutMapping("/updateJob")
         public boolean updateJobInfo(@RequestBody Job b) {
             return js.updateJobInfo(b);
         }
     /**
      * Add jobs to the database
      * 
      * @return String confirming successful or unsuccessful entry
      * @author John Thaddeus Kelly
      */
     @PostMapping("/saveJob")
     public boolean save(@RequestBody Job job) {
         try {
             js.insertJobInfo(job);
             return true;
         }catch (Exception e){
             return false;
         }
     }

     
//     @PostMapping("/updateJob")
//     public boolean updateJobInfo(@RequestBody Job b) {
//         return js.(b);
//     }
    
    /**
     * Retrieve jobs from the database
     * 
     * @return A list of jobs
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @GetMapping("/allJobs")
    public Iterable<Job> getAll(){
        return js.findAll();
    }
    
    
    /**
     * @author Adriana Long
     * @param title
     * @return job by title
     */
    @GetMapping("/jobTitle/{title}")
    public List<Job> getByTitle(@PathVariable String title){
        return js.findByTitle(title);
    }
}