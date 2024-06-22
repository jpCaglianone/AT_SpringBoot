package com.example.at_springboot;

import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.repository.DepartamentoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepartamentoIntegrationTest {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @BeforeEach
    public void setUp() {
        departamentoRepository.deleteAll();
    }

    @AfterEach
    public void tearDown() {
        departamentoRepository.deleteAll();
    }

    @Test
    public void testCreateDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNome("RH");
        departamento.setLocal("Edifício A");

        Departamento savedDepartamento = departamentoRepository.save(departamento);
        Optional<Departamento> foundDepartamento = departamentoRepository.findById(savedDepartamento.getId());

        assertTrue(foundDepartamento.isPresent());
        assertEquals("RH", foundDepartamento.get().getNome());
        assertEquals("Edifício A", foundDepartamento.get().getLocal());
    }

    @Test
    public void testUpdateDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNome("Financeiro");
        departamento.setLocal("Edifício B");

        Departamento savedDepartamento = departamentoRepository.save(departamento);
        savedDepartamento.setNome("TI");
        departamentoRepository.save(savedDepartamento);

        Optional<Departamento> foundDepartamento = departamentoRepository.findById(savedDepartamento.getId());

        assertTrue(foundDepartamento.isPresent());
        assertEquals("TI", foundDepartamento.get().getNome());
    }

    @Test
    public void testDeleteDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNome("Marketing");
        departamento.setLocal("Edifício C");

        Departamento savedDepartamento = departamentoRepository.save(departamento);
        departamentoRepository.deleteById(savedDepartamento.getId());

        Optional<Departamento> foundDepartamento = departamentoRepository.findById(savedDepartamento.getId());
        assertFalse(foundDepartamento.isPresent());
    }

    @Test
    public void testFindAllDepartamentos() {
        Departamento departamento1 = new Departamento();
        departamento1.setNome("Contabilidade");
        departamento1.setLocal("Edifício D");

        Departamento departamento2 = new Departamento();
        departamento2.setNome("Logística");
        departamento2.setLocal("Edifício E");

        departamentoRepository.save(departamento1);
        departamentoRepository.save(departamento2);

        Iterable<Departamento> departamentos = departamentoRepository.findAll();
        int count = 0;
        for (Departamento departamento : departamentos) {
            count++;
        }

        assertEquals(2, count);
    }
}
