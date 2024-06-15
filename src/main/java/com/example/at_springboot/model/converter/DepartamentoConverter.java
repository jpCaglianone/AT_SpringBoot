package com.example.at_springboot.model.converter;

import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.entity.Funcionario;
import com.example.at_springboot.model.dto.DepartamentoDTO;

import java.util.stream.Collectors;

public class DepartamentoConverter {

    public static DepartamentoDTO departamentoDTO(Departamento departamento) {
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setId(departamento.getId());
        dto.setNome(departamento.getNome());
        dto.setLocal(departamento.getLocal());
        return dto;
    }

    public static Departamento toEntity(DepartamentoDTO dto) {
        Departamento departamento = new Departamento();
        departamento.setId(dto.getId());
        departamento.setNome(dto.getNome());
        departamento.setLocal(dto.getLocal());
        return departamento;
    }
}
