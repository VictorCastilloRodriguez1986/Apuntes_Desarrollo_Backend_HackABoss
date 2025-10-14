package com.hackaboss.demo_sec.service;

import com.hackaboss.demo_sec.dto.PostDTO;
import com.hackaboss.demo_sec.entity.Post;
import com.hackaboss.demo_sec.entity.Usuario;
import com.hackaboss.demo_sec.repository.PostRepository;
import com.hackaboss.demo_sec.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void crearPost(Post post, String username) {
        if (post.getContenido() == null || post.getContenido().isBlank() || post.getContenido().length() > 280) {
            throw new IllegalArgumentException("Contenido inválido");
        }

        Usuario autor = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        post.setFechaCreacion(LocalDateTime.now());
        post.setAutor(autor);

        postRepository.save(post);
    }

    public List<PostDTO> obtenerTodos() {
        return postRepository.findAll().stream()
                .sorted(Comparator.comparing(Post::getFechaCreacion).reversed())
                .map(p -> new PostDTO(p.getContenido(), p.getFechaCreacion(), p.getAutor().getUsername()))
                .toList();
    }

    public List<PostDTO> obtenerMios(String username) {
        return postRepository.findByAutorUsernameOrderByFechaCreacionDesc(username).stream()
                .map(p -> new PostDTO(p.getContenido(), p.getFechaCreacion(), p.getAutor().getUsername()))
                .toList();
    }

    public void eliminarPost(Long id, String username) throws Exception {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Post no encontrado"));

        if (!post.getAutor().getUsername().equals(username)) {
            throw new AccessDeniedException("No puedes eliminar este post");
        }

        postRepository.delete(post);
    }
}