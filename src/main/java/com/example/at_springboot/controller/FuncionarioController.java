package com.example.at_springboot.controller;

import com.example.at_springboot.model.converter.FuncionarioConverter;
import com.example.at_springboot.model.entity.Funcionario;
import com.example.at_springboot.model.dto.FuncionarioDTO;
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

    @GetMapping("/listarTodos")
    public List<FuncionarioDTO> listarTodos() {
        return  funcionarioService.ListarTodos().stream()
                .map(FuncionarioConverter::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/inserir")
    public FuncionarioDTO criar(@RequestBody FuncionarioDTO funcionarioDTO) {
        System.out.println(funcionarioDTO);
        Funcionario funcionario = FuncionarioConverter.toEntity(funcionarioDTO);
        return FuncionarioConverter.toDTO(funcionarioService.Salvar(funcionario));
    }
}
