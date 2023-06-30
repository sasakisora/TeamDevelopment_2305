package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Re_CommentsEntity;

@Repository
public interface Re_CommentsRepository extends JpaRepository<Re_CommentsEntity, Integer> {

}