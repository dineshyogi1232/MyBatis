package com.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mybatis.model.User;
import com.mybatis.service.UserMapper;

@RestController
public class UserController {

	@Autowired
	UserMapper userMapper;

	@GetMapping("/show")
	public List<User> showListOfUsers() {
		return userMapper.getAllUsers();
	}

	@GetMapping("/show/id/{id}")
	public User getUserByID(@PathVariable("id") String id) {
		int userid = Integer.parseInt(id);
		return userMapper.getUserByID(userid);
	}

	@PostMapping("/save/{name}/{password}")
	public ResponseEntity<Map<String, Boolean>> saveUser(@PathVariable("name") String name,
			@PathVariable("password") String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		userMapper.saveUser(user);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Your data is saved", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/update/id/{id}/{name}/{password}")
	public ResponseEntity<Map<String, Boolean>> updateUser(@PathVariable("id") String id,
			@PathVariable("name") String name, @PathVariable("password") String password) {
		User user = new User();
		int userId = Integer.parseInt(id);
		user.setId(userId);
		user.setName(name);
		user.setPassword(password);
		userMapper.updateUser(user);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Your data is updated", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") String id) {
		int userId = Integer.parseInt(id);
		int deletedId = userMapper.deleteUser(userId);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Id " + deletedId + " is deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}