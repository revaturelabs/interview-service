package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.model.User;
import com.revature.repository.UserRepository;

/** A class to test the getAllUsers and findById methods of the UserService class.
 * @author Miranda Brawner */
public class UserServiceTest {

	private UserRepository repo = Mockito.mock(UserRepository.class);
	private UserService service = new UserService(repo);
	private User finn = new User(50, "Finn", "downwithkyloren", "Finn", "", new TreeSet<>());
	private User xavier = new User(35, "ProfessorX", "xmen", "Charles", "Xavier", new TreeSet<>());
	private User catwoman = new User(92, "Catwoman", "halleberry", "Selina", "Kyle", new TreeSet<>());
	private List<User> originalList = new ArrayList<>();
	
	@Before
	/** Populates an initial list of users for testing, and sets up the Mockito-simulated repository 
	 so that it behaves like a real repository would, from the point of view of the service class.*/
	public void setUp() {
		originalList.add(finn);
		originalList.add(xavier);
		originalList.add(catwoman);
		originalList.add(null);
		Mockito.when(repo.findAll()).thenReturn(originalList);
		Mockito.when(repo.findById(50)).thenReturn(finn);
		Mockito.when(repo.findById(35)).thenReturn(xavier);
		Mockito.when(repo.findById(92)).thenReturn(catwoman);
		Mockito.when(repo.findById(100)).thenReturn(null);
	}

	@Test
	/** Tests that the getAllUsers method in the service class calls the findAll method in the repository 
	 class, and that the service method returns the same list that the method in the repository method
	 provides. */
	public void testGetAll() {
		List<User> returnedList = service.getAllUsers();
		System.out.println("Testing getAllUsers method.");
		Mockito.verify(repo, Mockito.times(1)).findAll();
		System.out.println("Success: The findAll method of the repository was called as expected.");
		Assert.assertEquals(originalList, returnedList);
		System.out.println("Success: The returned list equals the expected list.");
		for (int index = 0; index < returnedList.size() && index < originalList.size(); index++) {
			Assert.assertEquals(originalList.get(index), returnedList.get(index));
			System.out.printf("Success: At index %d, the elements of the returned list and the expected "
					+ "list are equal.\n", index);
		}
		System.out.println("The getAllUsers test is complete.");
	}
	
	@Test
	/** Tests that the findById method in the service class calls the corresponding method in the repository 
	 class, and that the service method returns the same user that the repository method provides. */
	public void testFindById() {
		System.out.println("Testing findById method.");
		for (User originalUser: originalList) {
			int inputId = 100;
			String debugString = "[null]";
			if (originalUser != null) {
				inputId = originalUser.getId();
				debugString = originalUser.getUsername();
			}
			User returnedUser = service.findById(inputId);
			Mockito.verify(repo, Mockito.times(1)).findById(inputId);
			System.out.printf("Success: The findById method in the repository class was called "
					+ "with an id of %d.\n", inputId);
			Assert.assertEquals(originalUser, returnedUser);
			System.out.printf("Success: The user %s was retrieved successfully.\n", debugString);
		}
		System.out.println("The findById test is complete.");
	}
}
