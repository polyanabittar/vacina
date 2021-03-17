package com.zup.vacina.repository;

import java.util.List;

import com.zup.vacina.domain.Aplicacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
@Repository
public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long> {

    List<Aplicacao> findByEmail(String email);
       
}

