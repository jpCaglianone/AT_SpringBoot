package com.example.at_springboot.model.converter;

import com.example.at_springboot.model.dto.FuncionarioDTO;
import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.entity.Funcionario;
import com.example.at_springboot.model.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioConverter {

    private DepartamentoService departamentoService;

    @Autowired
    public FuncionarioConverter(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    public FuncionarioDTO toDTO(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setEndereco(funcionario.getEndereco());
        dto.setTelefone(funcionario.getTelefone());
        dto.setEmail(funcionario.getEmail());
        dto.setDataDeNascimento(funcionario.getDataDeNascimento());
        if (funcionario.getDepartamento() != null) {
            dto.setDepartamentoId(funcionario.getDepartamento().getId());
        }
        return dto;
    }

    public Funcionario toEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(dto.getId());
        funcionario.setNome(dto.getNome());
        funcionario.setEndereco(dto.getEndereco());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setEmail(dto.getEmail());
        funcionario.setDataDeNascimento(dto.getDataDeNascimento());

        if (dto.getDepartamentoId() != null) {
            funcionario.setDepartamento(departamentoService.BuscarPorId(dto.getDepartamentoId()));
        }

        return funcionario;
    }
}
