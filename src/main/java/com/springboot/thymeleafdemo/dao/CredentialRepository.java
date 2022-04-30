package com.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.thymeleafdemo.entity.Credential;

public interface CredentialRepository extends CrudRepository<Credential, Integer> {

	@Query("SELECT c FROM Credential c WHERE c.username = :username")
	public Credential getUserByUsername(@Param("username") String username);
}
