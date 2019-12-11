package com.revature.service;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = { CommentService.class, InterviewService.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class CommentServiceTest{

    //Services
    @Autowired
    private CommentService cs = new CommentService();
    @Autowired
    private InterviewService is;

    //Intializations
    Set<Skill> skillset = new HashSet<>();
    Set<Profile> profileset = new HashSet<>();
    Set<User> userset = new HashSet<>();
    Job job = new Job(1, "title", "description", skillset, true);
    Profile profile = new Profile(1, "Fred", "Jenkins", "description");
    Interview interview1 = new Interview(1, profile, Timestamp.from(Instant.now()), true, 
    job, userset);
    Comment comment1 = new Comment(2, Timestamp.from(Instant.now()), "name", "text", interview1);
    Interview interview2 = new Interview(2, profile, Timestamp.from(Instant.now()), true, 
    job, userset);

    @Before
    public void init(){
        is.insertInterviewInfo(interview1);
        cs.insertCommentWithInterview(interview1.getId(), comment1);
    }
    
    @Test
    public void testGetCommentsByInterview(){
        Interview interview1 = is.getById(1);
        assertEquals(comment1, cs.getCommentsByInterview(interview1.getId()));
    }

    @Test
    public void testInsertCommentWithInterview(){
        
        Comment comment2 = new Comment(1, Timestamp.from(Instant.now()), "name", "text", interview2);
        assertEquals(comment2, cs.insertCommentWithInterview(interview2.getId(), comment2));
    }

}