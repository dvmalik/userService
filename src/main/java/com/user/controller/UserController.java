package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.user.entity.User;
import com.user.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/userData")
public class UserController {

	@Autowired
	UserService userService;

	// fetch all user
	@ApiOperation(value = "This is Greetings!!!", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfull"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping("/")
	@ResponseBody
	public ResponseEntity<String> getHello() {
		System.out.println("getHello");
		return ResponseEntity.status(HttpStatus.OK).body("Hello world");
	}

	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<User> createUser(@RequestBody User user) {
		System.out.println("createUser : " + user);
		User entity = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	// fetch all user
	@GetMapping("/all")
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers() {
		System.out.println("createUser");
		List<User> users = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	// fetch user by id - calling career service
	@GetMapping("/{userId}")
	@ResponseBody
	public ResponseEntity<User> findUserProfileById(@PathVariable int userId) {
		System.out.println("findUserById : " + userId);
		User user = userService.findUserProfileById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
