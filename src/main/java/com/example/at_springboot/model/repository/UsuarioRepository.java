package com.example.at_springboot.model.repository;

import com.example.at_springboot.model.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
