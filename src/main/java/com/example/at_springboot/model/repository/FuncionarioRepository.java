package com.example.at_springboot.model.repository;

import com.example.at_springboot.model.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Funcionario f " +
            "SET f.nome = :nome, " +
            "f.endereco = :endereco, " +
            "f.email = :email, " +
            "f.telefone = :telefone, " +
            "f.dataDeNascimento = :dataDeNascimento, " +
            "f.departamento.id = :departamentoId " +
            "WHERE f.id = :id")
    int Editar(@Param("nome") String nome,
               @Param("endereco") String endereco,
               @Param("email") String email,
               @Param("telefone") String telefone,
               @Param("dataDeNascimento") LocalDate dataDeNascimento,
               @Param("departamentoId") Long departamentoId,
               @Param("id") Long id);
}
