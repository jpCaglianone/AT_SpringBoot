
package com.example.at_springboot;

import com.example.at_springboot.model.entity.Usuario;
import com.example.at_springboot.model.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testSaveUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome("Jane Doe");
        usuario.setSenha("1234");

        Usuario savedUsuario = usuarioRepository.save(usuario);

        assertThat(savedUsuario.getNome()).isEqualTo("Jane Doe");
        assertThat(savedUsuario.getSenha()).isEqualTo("1234");

    }
}
