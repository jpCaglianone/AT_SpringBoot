package com.example.at_springboot.model.service;

import com.example.at_springboot.model.entity.Funcionario;
import com.example.at_springboot.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<Funcionario> ListarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario Salvar(Funcionario funcionario){

        return funcionarioRepository.save(funcionario);
    }

}
