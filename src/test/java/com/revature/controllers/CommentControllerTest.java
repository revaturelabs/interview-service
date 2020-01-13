//package com.revature.controllers;
//
//import static org.junit.Assert.assertEquals;
//
//import java.sql.Timestamp;
//import java.time.Instant;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.revature.controller.CommentController;
//import com.revature.model.Comment;
//import com.revature.model.Interview;
//import com.revature.model.Job;
//import com.revature.model.Profile;
//import com.revature.model.Skill;
//import com.revature.model.User;
//import com.revature.service.CommentService;
//import com.revature.service.InterviewService;
//
//@SpringBootTest(classes = { CommentController.class, CommentService.class,
//        InterviewService.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@EnableJpaRepositories("com.revature.repository")
//@EntityScan("com.revature.model")
//@ComponentScan("com.revature.service")
//@EnableAutoConfiguration
//@TestPropertySource(locations = "classpath:application-test.properties")
//public class CommentControllerTest {
//
//    // Controllers
//    @InjectMocks
//    @Autowired
//    CommentController cc;
//
//    //Services
//    @Autowired
//    CommentService cs;
//    @Autowired
//    InterviewService is;
//
//    //Mock Calls
//    @Mock
//    HttpServletRequest request;
//    @Mock
//    HttpServletResponse response;
//
//    //Intializations
//    Set<Skill> skillset = new HashSet<>();
//    Set<Profile> profileset = new HashSet<>();
//    Set<User> userset = new HashSet<>();
//    Job job = new Job(1, "title", "description", skillset, true);
//    Profile profile = new Profile(1, "Fred", "Jenkins", "description");
//
//	/*
//	 * Interview interview1 = new Interview(1, profile,
//	 * Timestamp.from(Instant.now()), true, job, userset); Interview interview2 =
//	 * new Interview(2, profile, Timestamp.from(Instant.now()), true, job, userset);
//	 * Comment comment1 = new Comment(1, Timestamp.from(Instant.now()), "name",
//	 * "text", interview1); Comment comment2 = new Comment(2,
//	 * Timestamp.from(Instant.now()), "name", "text", interview2);
//	 */
//    @Before
//    public void init(){
//
//		/*
//		 * Comment comment1 = this.comment1; Interview interview1 = this.interview1;
//		 */
//   
//		/*
//		 * is.insertInterviewInfo(interview1);
//		 * cs.insertCommentWithInterview(interview1.getId(), comment1);
//		 */
//    }
//
//    //public List<Comment> findByInterviewId(@PathVariable int id)
//    @Test
//    public void testFindByInterviewId(){
//
//        //Comment comment = this.comment1;
//
//       // assertEquals(comment.getId(), cc.findByInterviewId(1).iterator().next().getId());
//    }
//
//    //public Comment insertComment(@RequestParam int id, @RequestBody Comment comment)
//    @Test
//    public void testInsertComment(){
//
//        //MockHttpServletRequest request = new MockHttpServletRequest();
//        //RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//        //when(cs.insertCommentWithInterview(any(Comment.class))).thenReturn(true);
//        //Comment comment = new Comment(1, Timestamp.from(Instant.now()), "name", "text", interview1);
//        //ResponseEntity<Comment> responseEntity = cc.insertComment(comment);
//        
//		/*
//		 * Comment comment3 = new Comment(3, Timestamp.from(Instant.now()), "name",
//		 * "text", interview1); Comment comment4 = cc.insertComment(interview1.getId(),
//		 * comment3);
//		 */    
//       // assertEquals(3, comment4.getId());
//    }
//   
//}
