package com.example.at_springboot.model.service;

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
        return departamentoRepository.findById(id).get();
    }

    public Departamento Salvar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento Editar(Departamento departamento) {
        return departamentoRepository.edit(departamento);
    }
}
