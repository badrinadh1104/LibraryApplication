package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.User;
import com.model.WishList;
import com.model.completedList;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	void save(WishList w);

	void save(completedList c);
	
	
	@Query("select p from User p where p.Email = :email and p.password =:password")
	public User FetchUserByEmailAndPassWord(@Param("email") String email,@Param("password") String password);
	
	@Query("select p.id from User p where p.Email = :email and p.password =:password")
	public int FetchUserByEmailAndPassWords(@Param("email") String email,@Param("password") String password);
	
	@Query("select p from User p where p.id =:id ")
	public User FetchUserDetails(@Param("id") int id);

	

	

}
