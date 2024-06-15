package com.example.at_springboot.controller;

import com.example.at_springboot.model.converter.DepartamentoConverter;
import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.dto.DepartamentoDTO;
import com.example.at_springboot.model.service.DepartamentoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/listarTodos")
    public List<DepartamentoDTO> listarTodos() {
        return departamentoService.ListarTodos().stream()
                .map(DepartamentoConverter::departamentoDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/inserir")
    public DepartamentoDTO criar(@RequestBody DepartamentoDTO funcionarioDTO) {
        Departamento departamento = DepartamentoConverter.toEntity(funcionarioDTO);
        return DepartamentoConverter.departamentoDTO(departamentoService.Salvar(departamento));
    }

    @PutMapping("/editar")
    public DepartamentoDTO editar(@RequestBody DepartamentoDTO departamento) {
       return departamentoService.Editar(departamento).streeam().map(DepartamentoConverter::departamentoDTO).collect(Collectors.toList());
}
