package com.zup.vacina.repository;

import java.util.List;

import com.zup.vacina.domain.Cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    List<Cadastro> findByCpf(String cpf);    
    List<Cadastro> findByEmail(String email);
    List<Cadastro> findByNome(String nome);
       
}