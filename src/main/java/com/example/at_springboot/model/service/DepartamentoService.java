package com.example.at_springboot.model.service;

import com.example.at_springboot.model.dto.DepartamentoDTO;
import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<Departamento> ListarTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento BuscarPorId(Long id) {
        return departamentoRepository.findById(id) .orElseThrow(() -> new RuntimeException("Departamento não encontrado com ID: " + id));
    }

    public Departamento Salvar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public int Editar(Departamento departamento) {
        int updatedRows = departamentoRepository.edit(departamento.getId(), departamento.getNome(), departamento.getLocal());
        return updatedRows;
    }

    public boolean Excluir(Long id) {
        try{
            departamentoRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
