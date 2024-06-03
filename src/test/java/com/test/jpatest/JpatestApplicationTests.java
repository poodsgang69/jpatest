package com.test.jpatest;

import com.test.jpatest.controller.UserController;
import com.test.jpatest.exception.DuplicateEmailFoundException;
import com.test.jpatest.exception.DuplicateNameFoundException;
import com.test.jpatest.exception.UserNotFoundException;
import com.test.jpatest.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.test.jpatest.model.User;

//import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpatestApplicationTests {

//	@Mock
//	private UserRepository userRepository;
//
//	@InjectMocks
//	private UserController userController;
//	@Autowired
//	private JpatestApplication jpaTestApplication;
//
//	@Test
//	void contextLoads() {
//		assertNotNull(jpaTestApplication);
//	}
//
//	@Test
//	void testFindProductById() {
//		User user = new User();
//
//		Long id = 1L;
//		user.setId(id);
//		user.setName("TestingName");
//		user.setEmail("TestingEmail@yml.com");
//		user.setUsername("testng123");
//
//		when(
//				userRepository.findById(id)
//		).thenReturn(
//				Optional.of(user)
//		);
//
//		Optional<User> result = userRepository.findById(id);
//
//		assertTrue(result.isPresent());
//		assertEquals("TestingName", result.get().getName());
//		assertEquals("TestingEmail@yml.com", result.get().getEmail());
//		assertEquals("testng123", result.get().getUsername());
//
//		verify(userRepository, times(1)).findById(id);
//
//	}
//
//	@Test
//	void testFindProductByIdNotFound() {
//		Long idToFind = 1L;
//
//		Mockito.when(
//				userRepository.findById(idToFind)
//		).thenReturn(
//				Optional.empty()
//		);
//
//		assertThrows(UserNotFoundException.class, () -> userController.getUserById(idToFind));
//
//		verify(userRepository, times(1)).findById(idToFind);
//	}
//
//	@Test
//	void testFindAllProducts() {
//		List<User> userList = new ArrayList<>();
//		userList.add(
//				new User(1L, "testng1", "Testing1", "testing1@test.com")
//		);
//		userList.add(
//				new User(2L, "testng2", "Testing2", "testing2@test.com")
//		);
//		userList.add(
//				new User(3L, "testng3", "Testing3", "testing3@test.com")
//		);
//
//		when(
//				userRepository.findAll()
//		).thenReturn(
//				userList
//		);
//
//		List<User> resultSet = userController.getAllUsers();
//		assertNotNull(resultSet);
//		assertEquals(userList.size(), resultSet.size());
//
//		//Check for each user
//		for (
//				int i = 0; i < resultSet.size(); i++
//		) {
//			User expectedUser = userList.get(i);
//
//			assertEquals(expectedUser.getId(), resultSet.get(i).getId());
//			assertEquals(expectedUser.getName(), resultSet.get(i).getName());
//			assertEquals(expectedUser.getEmail(), resultSet.get(i).getEmail());
//			assertEquals(expectedUser.getUsername(), resultSet.get(i).getUsername());
//		}
//
//		verify(userRepository, times(1)).findAll();
//	}
//
//	@Test
//	void testAddUser() {
//		User newUser = new User(
//				1L, "testng1", "Testing1", "testing1@test.com"
//		);
//
//		when(
//				userRepository.getByName(newUser.getName())
//		).thenReturn(
//				null
//		);
//
//		when(
//				userRepository.save(newUser)
//		).thenReturn(
//				newUser
//		);
//
//		User addedUser = userController.newUser(newUser);
////		User addedUser = userRepository.save(newUser);
//
//		assertNotNull(addedUser);
//		assertEquals(newUser.getName(), addedUser.getName());
//		assertEquals(newUser.getEmail(), addedUser.getEmail());
//		assertEquals(newUser.getUsername(), addedUser.getUsername());
//
//		verify(userRepository, times(1)).save(newUser);
//	}
//
//	@Test
//	void testAddUserDuplicateName() {
//		User origUser = new User(
//				1L, "testng1", "Testing1", "testing1@test.com"
//		);
//		User dupNameUser = new User(
//				2L, "testng2", "Testing1", "testing2@test.com"
//		);
//
//		when(
//				userRepository.getByName(origUser.getName())
//		).thenReturn(
//				dupNameUser.getName()
//		);
//
//		assertThrows(DuplicateNameFoundException.class, () -> userController.newUser(origUser));
//
//		verify(userRepository, times(1)).getByName(dupNameUser.getName());
//	}
//
//	@Test
//	void testAddUserDuplicateEmail() {
//		User origUser = new User(
//				1L, "testng1", "Testing1", "testing1@test.com"
//		);
//		User dupNameUser = new User(
//				2L, "testng2", "Testing2", "testing1@test.com"
//		);
//
//		when(
//				userRepository.getByEmail(origUser.getEmail())
//		).thenReturn(
//				dupNameUser.getEmail()
//		);
//
//		assertThrows(DuplicateEmailFoundException.class, () -> userController.newUser(origUser));
//
//		verify(userRepository, times(1)).getByEmail(dupNameUser.getEmail());
//	}
//
//	@Test
//	void testDeleteUser() {
//		List<User> userList = new ArrayList<>();
//		userList.add(new User(1L, "User1", "user1@example.com", "user1"));
//		userList.add(new User(2L, "User2", "user2@example.com", "user2"));
//		userList.add(new User(3L, "User3", "user3@example.com", "user3"));
//
//		// Assume idToDelete is defined
//		Long idToDelete = 1L;
//
//		// Mock the behavior of userRepository.findById to return the user with the specified ID
//		when(userRepository.existsById(idToDelete)).thenReturn(true);
//
//		// Mock the behavior of userRepository.delete to remove the user with the specified ID
////		doAnswer(invocation -> {
////			userList.removeIf(user -> user.getId().equals(idToDelete));
////			return null;
////		}).when(userRepository).deleteById(idToDelete);
//
//		doAnswer(invocation -> {
//			// Check if the user with the specified ID exists in the list
//			boolean userExists = userList.removeIf(user -> user.getId().equals(idToDelete));
//
//			// If user not found, throw UserNotFoundException
//			if (!userExists) {
//				throw new UserNotFoundException(idToDelete);
//			}
//
//			return null;
//		}).when(userRepository).deleteById(idToDelete);
//
//		when(
//				userRepository.findAll()
//		).thenReturn(
//				userList
//		);
//
//		// Call the controller method to delete the user and get the updated list
//		List<User> updatedUserList = userController.deleteUser(idToDelete);
//
//		// Verify that the deleteById method of userRepository was called once with the correct ID
//		verify(userRepository, times(1)).deleteById(idToDelete);
//
//		// Verify that the updatedUserList does not contain the deleted user
//		assertFalse(updatedUserList.stream().anyMatch(user -> user.getId().equals(idToDelete)));
//
//		// Optionally, you can assert other properties of the updated user list if needed
//		assertEquals(userList.size(), updatedUserList.size());
//	}
//
//	@Test
//	void testDeleteUserNotFound() {
//		User existingUser = new User(
//				1L, "test1", "testing1_user", "test1@testng.com"
//		);
//		Long idToDelete = 2L;
//
//		Mockito.when(
//				userRepository.existsById(idToDelete)
//		).thenReturn(false);
//
////		List<User> result = userController.deleteUser(idToDelete);
////		assertTrue(result.isEmpty());
//		assertThrows(UserNotFoundException.class, () -> userController.deleteUser(idToDelete));
//
//		verify(userRepository, times(1)).existsById(idToDelete);
//	}
//
//	@Test
//	void testUpdateUser () {
//		User origUser = new User(
//				1L, "User1", "user1@example.com", "user1"
//		);
//		User updatedUser = new User(
//				1L, "UPDATED_User1", "UPDATED_user1@example.com", "UPDATED_user1"
//		);
//
//		Mockito.when(
//				userRepository.findById(origUser.getId())
//		).thenReturn(
//				Optional.of(origUser)
//		);
//
//		Mockito.when(
//				userRepository.save(origUser)
//		).thenReturn(
//				updatedUser
//		);
//
//		User result = userController.updateUser(updatedUser, origUser.getId());
//
//		assertNotNull(result);
//		assertEquals(updatedUser, result);
//
//		verify(userRepository, times(1)).findById(origUser.getId());
//		verify(userRepository, times(1)).save(origUser);
//	}
//
//	@Test
//	void testUpdateUserNotFound() {
//		Long idToFind = 1L;
//		User updatedUser = new User(
//				1L, "User1", "user1", "user1@example.com"
//		);
//
//		Mockito.when(
//				userRepository.findById(idToFind)
//		).thenReturn(
//				Optional.empty()
//		);
//
////		User result = userController.updateUser(updatedUser, idToFind);
//
//		assertThrows(UserNotFoundException.class, () -> userController.updateUser(updatedUser, idToFind));
//
//		verify(userRepository, times(1)).findById(idToFind);
//	}
}
