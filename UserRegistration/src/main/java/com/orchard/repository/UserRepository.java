package com.orchard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orchard.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String tempUser);

	User findByUserNameAndPassword(String tempUserName, String tempPassword);

	

	
}
