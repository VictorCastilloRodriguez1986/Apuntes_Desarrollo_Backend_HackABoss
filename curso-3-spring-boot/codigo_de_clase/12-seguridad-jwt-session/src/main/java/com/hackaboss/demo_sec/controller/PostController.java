package com.hackaboss.demo_sec.controller;

import com.hackaboss.demo_sec.dto.PostDTO;
import com.hackaboss.demo_sec.entity.Post;
import com.hackaboss.demo_sec.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> obtenerTodos() {
        return postService.obtenerTodos();
    }

    @GetMapping("/mios")
    public List<PostDTO> obtenerMios(Authentication auth) {
        return postService.obtenerMios(auth.getName());
    }

    @PostMapping
    public ResponseEntity<String> crearPost(@RequestBody Post post, Authentication auth) {
        postService.crearPost(post, auth.getName());
        return ResponseEntity.ok("Post creado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPost(@PathVariable Long id, Authentication auth) throws Exception {
        postService.eliminarPost(id, auth.getName());
        return ResponseEntity.ok("Post eliminado");
    }
}