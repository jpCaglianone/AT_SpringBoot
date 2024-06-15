package com.example.at_springboot;

import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.entity.Funcionario;
import com.example.at_springboot.model.repository.DepartamentoRepository;
import com.example.at_springboot.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class DataInitializer implements CommandLineRunner {

    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Cria e salva o departamento
        Departamento departamento1 = new Departamento();
        departamento1.setLocal("qualquer");
        departamento1.setNome("ADM");

        departamento1 = departamentoRepository.save(departamento1);

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("Fulano");
        funcionario1.setEndereco("Rua dos bobos");
        funcionario1.setEmail("fulano@gmail.com");
        funcionario1.setDataDeNascimento(LocalDate.of(1994, 5, 14));
        funcionario1.setTelefone("214781904710");
        funcionario1.setDepartamento(departamento1);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario1);

        funcionarioRepository.saveAll(funcionarios);

        departamentoRepository.save(departamento1);
    }
}
