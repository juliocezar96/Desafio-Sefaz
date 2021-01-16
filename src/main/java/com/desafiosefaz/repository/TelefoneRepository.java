package com.desafiosefaz.repository;

import com.desafiosefaz.model.Telefone;
import com.desafiosefaz.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelefoneRepository extends JpaRepository<Telefone,Long> {

}
