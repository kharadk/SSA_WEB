package com.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssa.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

}