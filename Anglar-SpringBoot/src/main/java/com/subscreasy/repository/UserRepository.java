package com.subscreasy.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.subscreasy.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmailIgnoreCase(String username);
	

	

}
