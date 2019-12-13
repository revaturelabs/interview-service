package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import com.revature.model.Job;
import com.revature.model.Skill;
import com.revature.service.JobService;
import com.revature.service.SkillService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/jobs")
public class JobController {
    
    @Autowired
    private JobService js;
    @Autowired
    private SkillService ss;

    /**
     * Add jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @PostMapping("/saveJob")
    @Transactional
    public boolean insertJobInfo(@RequestBody Job job) {
        Set<Skill> skills = new HashSet<Skill>();
        for (Skill s : job.getSkills()) {
            Skill tempSkill = ss.findSkill(s.getTitle());
            // tempSkill.setId(0);
            skills.add(tempSkill);
        }
        job.setSkills(skills);
        return js.insertJobInfo(job);
    }

    /**
     * Update jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author william liederer
     */
    @PatchMapping("/updateJob")
    public boolean updateJobInfo(@RequestBody Job b) {
        return js.updateJobInfo(b);
    }

    /**
     * Retrieve jobs from the database
     * 
     * @return A list of jobs
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @GetMapping("/allJobs")
    public Iterable<Job> getAll() {
        return js.findAll();
    }

    /**
     * @author Adriana Long
     * @param title
     * @return job by title
     */
    @GetMapping("/jobTitle/{title}")
    public Job getByTitle(@PathVariable String title) {
        return js.findByTitle(title);
    }
}