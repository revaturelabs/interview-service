/**
 * @author Miranda Brawner January 10, 2020 Profile Controller Unit Test
 * 
 *         Source Used: Stack Overflow. "Unit testing a class with autowired
 *         notation using Junit and EasyMock?"
 *         https://stackoverflow.com/questions/9807882/unit-testing-a-class-with-autowired-notation-using-junit-and-easymock
 */
  package com.revature.controllers;
  import static org.junit.Assert.assertEquals; 
  import static org.junit.Assert.assertTrue;
  import java.util.ArrayList; 
  import java.util.List;
  import org.junit.Before; 
  import org.junit.Test; 
  import org.mockito.Mockito;
  import org.springframework.test.util.ReflectionTestUtils;
  import com.revature.controller.ProfileController;
  import com.revature.model.Profile;
  import com.revature.service.ProfileService;
  public class ProfileControllerTest {
	  
  ProfileController trueController;
  ProfileController falseController;
  ProfileService trueService;
  ProfileService falseService; 
  Profile profileOne;
  Profile profileTwo;
	  @Before
	 /**
		 * Creates two instances each of the profile, service, and controller classes,
		 * using Mockito mock instances in the case of service.
		 */
	public void setup() {
		trueService = Mockito.mock(ProfileService.class);
		falseService = Mockito.mock(ProfileService.class);
		profileOne = new Profile(1, "Carrie", "Jones", "NYC", "test@gmail.com", "This is a test profile.");
		profileTwo = new Profile(2, "Oscar", "Smith", "LA", "test1@gmail.com", "This is another test profile.");
		trueController = new ProfileController();
		falseController = new ProfileController();
		
		ReflectionTestUtils.setField(trueController, "profileService", trueService);
		ReflectionTestUtils.setField(falseController, "profileService", falseService);
		
		Mockito.when(trueService.insertProfileInfo(profileOne)).thenReturn(true);
		Mockito.when(trueService.insertProfileInfo(profileTwo)).thenReturn(true);
		Mockito.when(falseService.insertProfileInfo(profileOne)).thenReturn(false);
		Mockito.when(falseService.insertProfileInfo(profileTwo)).thenReturn(false);
		
		List<Profile> listOfTwo = new ArrayList<>();
		listOfTwo.add(profileOne);
		listOfTwo.add(profileTwo);
		
		List<Profile> emptyList = new ArrayList<>();
		Mockito.when(trueService.getAllProfiles()).thenReturn(listOfTwo);
		Mockito.when(falseService.getAllProfiles()).thenReturn(emptyList);
	}
  @Test
 /**
	 * Tests the controller method that takes a profile and sends it to the
	 * controller. The first controller has a service member that always returns
	 * true, and the second one has a service member that always returns false. The
	 * controllers should echo the return values of their service members.
	 */
	public void testInsertProfileInfo() {
		boolean result = trueController.insertProfileInfo(profileOne);
		String resultString = result ? "Success" : "Failure";
		System.out.printf("Test 1: %s. insertProfileInfo returned %s. (Expected: true.)\n", resultString, result);
		assertTrue(result);
		result = falseController.insertProfileInfo(profileOne);
		resultString = result ? "Failure" : "Success";
		System.out.printf("Test 2: %s. insertProfileInfo returned %s. (Expected: false.)\n", resultString, result);
		assertTrue(!result);
	}
  @Test
 /**
	 * Tests the controller method that retrieves a list of profiles from the
	 * service class and returns it. Two controllers are assigned different service
	 * members, each with their own list of profiles. The controllers should return
	 * the same lists that their service members were given.
	 */
	public void testGetAll() {
	  
		List<Profile> firstReturnedList = trueController.getAll();
		boolean result = firstReturnedList.get(0) == profileOne;
		String resultString = result ? "Success" : "Failure";
		String match = result ? "matched" : "did not match";
		System.out.printf("Test 3: %s. The first returned profile of getAll %s the expected profile.\n", resultString,
				match);
		
		result = firstReturnedList.get(1) == profileTwo;
		resultString = result ? "Success" : "Failure";
		match = result ? "matched" : "did not match";
		System.out.printf("Test 4: %s. The second returned profile of getAll %s the expected profile.\n", resultString,
				match);
		
		List<Profile> secondReturnedList = falseController.getAll();
		
		int length = secondReturnedList.size();
		resultString = (length == 0) ? "Success" : "Failure";
		
		System.out.printf("Test 5: %s. The returned list had a length of %d. (Expected: 0)\n", resultString, length);
		assertEquals(length, 0);
	}
  }