package com.example.at_springboot.model.converter;

import com.example.at_springboot.model.entity.Funcionario;
import com.example.at_springboot.model.dto.FuncionarioDTO;

public class FuncionarioConverter {

    public static FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setEndereco(funcionario.getEndereco());
        dto.setTelefone(funcionario.getTelefone());
        dto.setEmail(funcionario.getEmail());
        dto.setDataDeNascimento(funcionario.getDataDeNascimento());
        dto.setDepartamentoId(funcionario.getDepartamento() != null ? funcionario.getDepartamento().getId() : null);
        return dto;
    }

    public static Funcionario toEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(dto.getId());
        funcionario.setNome(dto.getNome());
        funcionario.setEndereco(dto.getEndereco());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setEmail(dto.getEmail());
        funcionario.setDataDeNascimento(dto.getDataDeNascimento());

        return funcionario;
    }
}
