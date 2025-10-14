package com.hackaboss.demo_sec.repository;

import com.hackaboss.demo_sec.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAutorUsernameOrderByFechaCreacionDesc(String username);
}