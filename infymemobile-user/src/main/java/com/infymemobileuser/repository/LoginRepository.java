package com.infymemobileuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infymemobileuser.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

}
