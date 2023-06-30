package com.example.demo.listrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.listentity.UserlistEntity;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserlistRepository extends JpaRepository<UserlistEntity, Long> {
    List<UserlistEntity> findByContentContaining(String keyword);
}


