package com.infymemobileuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infymemobileuser.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	//Optional<UserEntity> findByuserId(String userId);

//	@Query("Select userId from UserEntity where userId=:? ")
	Optional<UserEntity> findByUserId(String userId);

}
