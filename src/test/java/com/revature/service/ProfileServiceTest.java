package com.revature.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.model.Profile;
import com.revature.repository.ProfileRepository;


/*
 * Tester class for ProfileService. Rewritten to use Mockito.
 * @author: redc
 * @created: 13JAN2020
 */

public class ProfileServiceTest {
	
	//Mockito starter stuff.
	@Rule
	public MockitoRule mockRule = MockitoJUnit.rule();

	@Mock
	ProfileRepository profRep;
	
	@InjectMocks
	ProfileService profServ;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}
	
	//CONSTRUCTORS

	@Test
	public void testProfileService() {
		System.out.println("in ProfileService()");
		
		ProfileService testServ = new ProfileService();
		if (testServ.getClass() != ProfileService.class)
		{
			fail("Constructor not working.");
		}	
	}

	@Test
	public void testProfileServiceProfileRepository() {
		System.out.println("in ProfileService(ProfileRepository)");
		
		ProfileService testServ = new ProfileService(profRep);
		if (testServ.getClass() != ProfileService.class)
		{
			fail("POR QUE?!");
		}	
	}

	@Test
	public void testFindAllByLastName() {
		System.out.println("in findAllByLastName");

		List<Profile> profList = new ArrayList<>();
		Profile profA = new Profile();
		profA.setFirstName("Mark");
		profA.setLastName("Andrews");
		profList.add(profA);
		
		Profile profB = new Profile();
		profA.setFirstName("Bobson");
		profA.setLastName("Dugnutt");
		profList.add(profB);
		
		Profile profC = new Profile();
		profA.setFirstName("Andrew");
		profA.setLastName("Andrews");
		profList.add(profC);
		
		when
		
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		System.out.println("in findById");

		fail("Not yet implemented");
	}

	@Test
	public void testInsertProfileInfo() {
		System.out.println("in insertProfileInto");

		fail("Not yet implemented");
	}

	@Test
	public void testGetAllProfiles() {
		System.out.println("in getAllProfiles");

		fail("Not yet implemented");
	}

}
