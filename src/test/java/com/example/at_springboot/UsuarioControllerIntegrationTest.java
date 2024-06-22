package com.example.at_springboot;

import com.example.at_springboot.model.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@SpringJUnitConfig
public class UsuarioControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateUsuario() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("meuusuario", "minhasenha");

        String url = "http://localhost:" + port + "/usuarios";
        Usuario usuario = new Usuario();
        usuario.setNome("Joao Pedro");
        usuario.setSenha("1234");

        ResponseEntity<Usuario> responseEntity = restTemplate.postForEntity(url, usuario, Usuario.class);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getNome()).isEqualTo("Joao Pedro");
        assertThat(responseEntity.getBody().getSenha()).isEqualTo("1234");
    }

    @Test
    public void testGetUsuario() {
        String url = "http://localhost:" + port + "/usuarios/{id}";

        ResponseEntity<Usuario> responseEntity = restTemplate.getForEntity(url, Usuario.class, 1L);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

    }

    @Test
    public void testUpdateUsuario() {
        String url = "http://localhost:" + port + "/usuarios/{id}";

        Usuario usuario = new Usuario();
        usuario.setNome("Jane Doe");
        usuario.setSenha("5678");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Usuario> requestEntity = new HttpEntity<>(usuario, headers);

        ResponseEntity<Usuario> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Usuario.class, 1L);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getNome()).isEqualTo("Jane Doe");
        assertThat(responseEntity.getBody().getSenha()).isEqualTo("5678");
    }

    @Test
    public void testDeleteUsuario() {
        String url = "http://localhost:" + port + "/usuarios/{id}";

        ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class, 1L);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
