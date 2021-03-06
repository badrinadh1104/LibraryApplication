package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.User;
import com.model.WishList;
import com.model.completedList;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User addBooktoWishList(int userid,int wbkid) {
		User user = userRepository.getById(userid);
		WishList wbk = new WishList(wbkid);
		user.AddtoWishList(wbk);
		userRepository.save(wbk);
		return user;
	}
	public User addBooktocompletedList(int userid,int Bookid) {
		User user = userRepository.getById(userid);
		completedList cmbk = new completedList(Bookid);
		user.AddtoCompletedList(cmbk);
		userRepository.save(cmbk);
		return user;
	}
	
	public List<User> RetriveUsers(){
		List<User> userlist= new ArrayList<User>();
		userlist=userRepository.findAll();
		return userlist;
	}
	
	public User FeetchUserByemailAndPassword(String email,String pass) {
		return userRepository.FetchUserByEmailAndPassWord(email,pass);
	}
	
	
	public int RetriveUserIdfromEmailPass(String email,String pass){
		return userRepository.FetchUserByEmailAndPassWords(email, pass);	
	}
	
	public User retiveFullUserDetails(int id) {
		return userRepository.FetchUserDetails(id);
	}
	
	

}
