package com.example.at_springboot.model.repository;

import com.example.at_springboot.model.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {


    @Modifying
    @Transactional
    @Query("Update Departamento d SET" +
            "d.nome = :nome," +
            "d.local = :local" +
            "where d.id = :id")
    Departamento edit (@Param("id") int id, @Param("nome") int nome, @Param("local") int local);
}
