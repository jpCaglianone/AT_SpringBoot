package com.example.at_springboot.model.service;

import com.example.at_springboot.model.dto.DepartamentoDTO;
import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.exceptions.ValidacaoException;
import com.example.at_springboot.model.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    UtilitarioValidacao utilitarioValidacao;

    public List<Departamento> ListarTodos() {
        return departamentoRepository.findAll();
    }

    public Departamento BuscarPorId(Long id) {
        if (!utilitarioValidacao.verificarId(id)) {
            Departamento departamento = new Departamento();
            return departamento;
        }
        return departamentoRepository.findById(id) .orElseThrow(() -> new RuntimeException("Departamento não encontrado com ID: " + id));
    }

    public Departamento Salvar(Departamento departamento) {
        if (!utilitarioValidacao.verificarVazioString(departamento.getNome()) ||
                !utilitarioValidacao.verificarVazioString(departamento.getLocal()) ) {
            departamento = new Departamento();
            return departamento;
        }

        return departamentoRepository.save(departamento);
    }

    public int Editar(Departamento departamento) {
        int updatedRows = departamentoRepository.edit(departamento.getId(), departamento.getNome(), departamento.getLocal());
        return updatedRows;
    }

    public boolean Excluir(Long id) {
        System.out.println(id);
        System.out.println(id);
        System.out.println(id);
        
        if (!utilitarioValidacao.verificarId(id)) {
            throw new ValidacaoException("id incorreto");

        }

        try{
            departamentoRepository.deleteById(id);


            return true;
        }
        catch (Exception e) {
            throw new ValidacaoException("id incorreto");

        }
    }
}
