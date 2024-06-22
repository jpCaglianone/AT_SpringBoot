package com.example.at_springboot;

import com.example.at_springboot.model.entity.Usuario;
import com.example.at_springboot.model.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UsuarioIntegrationTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        usuarioRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        usuarioRepository.deleteAll();
    }

    @Test
    public void testCreateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Test User");
        usuario.setSenha("12345");
        usuario.setPapel("ADMIN");

        Usuario savedUsuario = usuarioRepository.save(usuario);
        Optional<Usuario> foundUsuario = usuarioRepository.findById(savedUsuario.getId());

        assertTrue(foundUsuario.isPresent());
        assertEquals("Test User", foundUsuario.get().getNome());
        assertEquals("12345", foundUsuario.get().getSenha());
        assertEquals("ADMIN", foundUsuario.get().getPapel());
    }

    @Test
    public void testUpdateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Test User");
        usuario.setSenha("12345");
        usuario.setPapel("ADMIN");

        Usuario savedUsuario = usuarioRepository.save(usuario);
        savedUsuario.setNome("Updated User");
        usuarioRepository.save(savedUsuario);

        Optional<Usuario> foundUsuario = usuarioRepository.findById(savedUsuario.getId());

        assertTrue(foundUsuario.isPresent());
        assertEquals("Updated User", foundUsuario.get().getNome());
    }

    @Test
    public void testDeleteUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Test User");
        usuario.setSenha("12345");
        usuario.setPapel("ADMIN");

        Usuario savedUsuario = usuarioRepository.save(usuario);
        usuarioRepository.deleteById(savedUsuario.getId());

        Optional<Usuario> foundUsuario = usuarioRepository.findById(savedUsuario.getId());
        assertFalse(foundUsuario.isPresent());
    }

    @Test
    public void testFindAllUsuarios() {
        Usuario usuario1 = new Usuario();
        usuario1.setNome("User One");
        usuario1.setSenha("12345");
        usuario1.setPapel("ADMIN");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("User Two");
        usuario2.setSenha("67890");
        usuario2.setPapel("USER");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        int count = 0;
        for (Usuario usuario : usuarios) {
            count++;
        }

        assertEquals(2, count);
    }
}
