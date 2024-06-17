package com.example.at_springboot.model.service;

import com.example.at_springboot.model.entity.Funcionario;
import com.example.at_springboot.model.repository.DepartamentoRepository;
import com.example.at_springboot.model.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    DepartamentoService departamentoService;

    public List<Funcionario> ListarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario Salvar(Funcionario funcionario){

        return funcionarioRepository.save(funcionario);
    }

    public int Editar (Funcionario funcionario){
        return funcionarioRepository.Editar(funcionario.getNome(),
                funcionario.getEndereco(),
                funcionario.getEmail(),
                funcionario.getTelefone(),
                funcionario.getDataDeNascimento(),
                funcionario.getDepartamento().getId(),
                funcionario.getId());
    }

    public String Excluir (Long id){

        try{
            funcionarioRepository.deleteById(id);
            return "Funcionario deletado com sucesso";
        }
        catch (Exception e){
            return "Não foi possivel excluir funcionário!" + e;
        }

    }

}
