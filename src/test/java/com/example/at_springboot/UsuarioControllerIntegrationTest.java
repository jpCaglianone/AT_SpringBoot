package com.example.at_springboot;

import com.example.at_springboot.model.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateUsuario() {
        String url = "http://localhost:" + port + "/usuarios";
        Usuario usuario = new Usuario();
        usuario.setNome("John Doe");
        usuario.setSenha("1234");

        ResponseEntity<Usuario> responseEntity = restTemplate.postForEntity(url, usuario, Usuario.class);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getNome()).isEqualTo("Joao Pedro");
        assertThat(responseEntity.getBody().getSenha()).isEqualTo("1234");
    }
}
