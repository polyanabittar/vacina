package com.zup.vacina.service;

import java.util.List;

import com.zup.vacina.domain.Aplicacao;
import com.zup.vacina.domain.Cadastro;
import com.zup.vacina.repository.AplicacaoRepository;
import com.zup.vacina.repository.CadastroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AplicacaoService {
    @Autowired
    public CadastroRepository cadastroRepository;

    @Autowired
    AplicacaoRepository aplicacaoRepository;

    public Aplicacao existeVac(Aplicacao aplicacao) throws Exception {

        if (!existeEmail (aplicacao.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"E-mail não cadastrado na base de dados.");
        }
        else {
            return aplicacaoRepository.save(aplicacao);
        }
    }

    public boolean existeEmail(String email) {
        List<Cadastro> buscaEmail = cadastroRepository.findByEmail(email);
        if (buscaEmail != null && !buscaEmail.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Aplicacao> buscarEmail (String email) {
        return aplicacaoRepository.findByEmail(email);
    }
}