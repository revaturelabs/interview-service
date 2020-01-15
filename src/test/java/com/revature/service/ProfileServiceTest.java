package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

	//Method name misleading. Currently only returns single profile. Ian is working on fix.
	@Test
	public void testFindAllByLastName() {
		System.out.println("in findAllByLastName");

		List<Profile> profList = new ArrayList<>();
		Profile profA = Mockito.mock(Profile.class);
		profA.setFirstName("Mark");
		profA.setLastName("Andrews");
		profList.add(profA);
		
		Profile profB = Mockito.mock(Profile.class);
		profA.setFirstName("Bobson");
		profA.setLastName("Dugnutt");
		profList.add(profB);
		
		Profile profC = Mockito.mock(Profile.class);
		profA.setFirstName("Andrew");
		profA.setLastName("Andrews");
		profList.add(profC);
		
		when(profRep.findByLastName("Dugnutt")).thenReturn(profB);
		
		//TESTER
		
		Profile testProf = profServ.findAllByLastName("Dugnutt");
		assertEquals(testProf, profB);
		verify(profRep, times(1)).findByLastName("Dugnutt");
		
	}

	@Test
	public void testFindById() {
		System.out.println("in findById");

		Profile testProf = Mockito.mock(Profile.class);
		testProf.setId(2);
		testProf.setFirstName("John");
		testProf.setLastName("Oliver");
		
		when(profRep.findById(2)).thenReturn(testProf);
		
		Profile reqProf = profServ.findById(2);
		assertEquals(reqProf, testProf);
		verify(profRep, times(1)).findById(2);	
	}

	//Method returns a boolean?! WHY.
	@Test
	public void testInsertProfileInfo() {
		System.out.println("in insertProfileInfo");
		
		Profile oldProf = Mockito.mock(Profile.class);
		oldProf.setFirstName("Carm");
		oldProf.setLastName("O'Chameleon");
		
		Profile newProf = oldProf;
		newProf.setLastName("Mella");
		
		//when(profRep.mergeEntity(newProf)).thenReturn(newProf);
		
		Profile reqProf = profRep.save(oldProf);
		Boolean request = profServ.insertProfileInfo(newProf);
		
		assertTrue(request);
		verify(profRep, times(1)).mergeEntity(newProf);
	}

	@Test
	public void testGetAllProfiles() {
		System.out.println("in getAllProfiles");
		

		List<Profile> profList = new ArrayList<>();
		Profile profA = Mockito.mock(Profile.class);
		profA.setFirstName("Mark");
		profA.setLastName("Andrews");
		profList.add(profA);
		
		Profile profB = Mockito.mock(Profile.class);
		profA.setFirstName("Bobson");
		profA.setLastName("Dugnutt");
		profList.add(profB);
		
		Profile profC = Mockito.mock(Profile.class);
		profA.setFirstName("Andrew");
		profA.setLastName("Andrews");
		profList.add(profC);
		
		when(profRep.findAll()).thenReturn(profList);
		
		List<Profile> reqList = profServ.getAllProfiles();
		
		assertEquals(reqList, profList);
		verify(profRep, times(1)).findAll();

	}

}
