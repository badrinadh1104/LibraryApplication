package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.model.WishList;
import com.model.completedList;
import com.service.UserService;

@RestController
@RequestMapping("Library")
@CrossOrigin

public class LibController {
	@Autowired
	private UserService service;

	@PostMapping(value = "addUser",consumes = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user ) {
		return service.saveUser(user);
	}
	
	@PostMapping(value = "AddBooktowishList")
	public WishList addBooktowishList( int userid, int wbk) {
		  service.addBooktoWishList(userid, wbk);
		  return new WishList(wbk);
	}
	@PostMapping(value="AddBooktocompletedList")
	public void addbooktoCompletedList( int userid,int  cmbk) {
		  service.addBooktocompletedList(userid, cmbk);
	}
	@GetMapping(value="getallUsers",produces =   MediaType.APPLICATION_JSON_VALUE)
	public List<User> getallUsers(){
		return service.RetriveUsers();
	}
	@PostMapping(value = "login",consumes = MediaType.APPLICATION_JSON_VALUE)
	//@CrossOrigin(origins = "http://localhost:4200/")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempemailid= user.getEmail();
		String temppass= user.getPassword();
		User userobj =null;
		if(tempemailid !=null && temppass !=null) {
			 userobj= service.FeetchUserByemailAndPassword(tempemailid, temppass);
		}
		if(userobj== null) {
			throw new Exception("Bad credentials");
		}
		return service.FeetchUserByemailAndPassword(tempemailid, temppass);
	}
	
	@GetMapping(value = "ForUserId/{email}/{pass}")
	public int UserIdfromemailPass(@PathVariable("email") String email,@PathVariable("pass") String pass) {
		return service.RetriveUserIdfromEmailPass(email, pass);
	}
	@GetMapping(value="ForUserDetails/{id}")
	public User getUserFullDetails(@PathVariable("id") int id) {
		return service.retiveFullUserDetails(id);
	}
	


}
