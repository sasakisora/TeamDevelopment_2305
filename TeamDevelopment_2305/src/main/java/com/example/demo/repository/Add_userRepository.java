package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Add_userEntity;

@Repository
public interface Add_userRepository extends JpaRepository<Add_userEntity, Integer> {

}