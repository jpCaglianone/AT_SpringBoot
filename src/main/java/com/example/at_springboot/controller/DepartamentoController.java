package com.example.at_springboot.controller;

import com.example.at_springboot.model.converter.DepartamentoConverter;
import com.example.at_springboot.model.entity.Departamento;
import com.example.at_springboot.model.dto.DepartamentoDTO;
import com.example.at_springboot.model.repository.DepartamentoRepository;
import com.example.at_springboot.model.service.DepartamentoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/listarTodos")
    public List<DepartamentoDTO> listarTodos() {
        return departamentoService.ListarTodos().stream()
                .map(DepartamentoConverter::departamentoDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/inserir")
    public DepartamentoDTO criar(@RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = DepartamentoConverter.toEntity(departamentoDTO);
        return DepartamentoConverter.departamentoDTO(departamentoService.Salvar(departamento));
    }

    @PutMapping("/editar")
    public String editar(@RequestBody DepartamentoDTO departamentoDTO) {

        Departamento departamento = DepartamentoConverter.toEntity(departamentoDTO);
        int linhasAfetadas = departamentoService.Editar(departamento);
        if (linhasAfetadas == 0){
            return "Nenhuma linha afetada";
        }
        else{
            String mensagem = linhasAfetadas + " linhas afetadas";
            return mensagem;
        }
    }


    @DeleteMapping("/deletar")
    public String deletar(@RequestBody Long id) {

        if (departamentoService.Excluir(id)){
            return "exclusao realizada";
        }
        else {
            return "exclusao nao pode ser realizada";
        }
    }

    @GetMapping("/um")
    public Optional<Departamento> um (@RequestBody Long id){

        Optional<Departamento> departamento = Optional.ofNullable(departamentoService.BuscarPorId(id));

        return departamento;
    }
}
