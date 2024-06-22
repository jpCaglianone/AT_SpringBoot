package com.example.at_springboot;

import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.entity.Funcionario;
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
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@SpringJUnitConfig
public class FuncionarioControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateFuncionario() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("meuusuario", "minhasenha");

        String url = "http://localhost:" + port + "/funcionario";
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Joao Pedro");
        funcionario.setEndereco("Rua Teste, 123");
        funcionario.setEmail("joao.pedro@example.com");
        funcionario.setTelefone("(11) 9999-9999");
        funcionario.setDataDeNascimento(LocalDate.of(1990, 5, 15));

        Departamento departamento = new Departamento();
        departamento.setNome("TI");
        departamento.setId(1L);
        funcionario.setDepartamento(departamento);

        ResponseEntity<Funcionario> responseEntity = restTemplate.postForEntity(url, funcionario, Funcionario.class);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getNome()).isEqualTo("Joao Pedro");
        assertThat(responseEntity.getBody().getEmail()).isEqualTo("joao.pedro@example.com");
    }

    @Test
    public void testGetFuncionario() {
        String url = "http://localhost:" + port + "/funcionario/{id}";

        ResponseEntity<Funcionario> responseEntity = restTemplate.getForEntity(url, Funcionario.class, 1L);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getId()).isEqualTo(1L);
    }

    @Test
    public void testUpdateFuncionario() {
        String url = "http://localhost:" + port + "/funcionario/{id}";

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Jane Doe");
        funcionario.setEndereco("Rua Nova, 456");
        funcionario.setEmail("jane.doe@example.com");
        funcionario.setTelefone("(11) 8888-8888");
        funcionario.setDataDeNascimento(LocalDate.of(1985, 10, 20));

        Departamento departamento = new Departamento();
        departamento.setNome("Financeiro");
        departamento.setId(2L);
        funcionario.setDepartamento(departamento);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Funcionario> requestEntity = new HttpEntity<>(funcionario, headers);

        ResponseEntity<Funcionario> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Funcionario.class, 1L);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getNome()).isEqualTo("Jane Doe");
        assertThat(responseEntity.getBody().getEmail()).isEqualTo("jane.doe@example.com");
    }

    @Test
    public void testDeleteFuncionario() {
        String url = "http://localhost:" + port + "/funcionario/{id}";

        ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class, 1L);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}
