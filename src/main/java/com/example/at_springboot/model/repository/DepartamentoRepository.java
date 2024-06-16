package com.example.at_springboot.model.repository;

import com.example.at_springboot.model.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Departamento d SET d.nome = :nome, d.local = :local WHERE d.id = :id")
    int edit(@Param("id") Long id, @Param("nome") String nome, @Param("local") String local);
}
