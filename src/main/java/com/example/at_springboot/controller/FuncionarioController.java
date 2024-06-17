package com.example.at_springboot.controller;

import com.example.at_springboot.model.converter.FuncionarioConverter;
import com.example.at_springboot.model.dto.FuncionarioDTO;
import com.example.at_springboot.model.entity.Funcionario;
import com.example.at_springboot.model.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioConverter funcionarioConverter;

    @GetMapping("/listarTodos")
    public List<FuncionarioDTO> listarTodos() {
        return funcionarioService.ListarTodos().stream()
                .map(funcionarioConverter::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/inserir")
    public FuncionarioDTO criar(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioConverter.toEntity(funcionarioDTO);
        return funcionarioConverter.toDTO(funcionarioService.Salvar(funcionario));
    }

    @PutMapping("/editar")
    public String editar(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioConverter.toEntity(funcionarioDTO);

        int linhasAfetadas = funcionarioService.Editar(funcionario);
        return "edicao concluida";
    }

    @DeleteMapping("/excluir")
    public String deletar(@RequestBody Long id) {
        return funcionarioService.Excluir(id);
    }
}
