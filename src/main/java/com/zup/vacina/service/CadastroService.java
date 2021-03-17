package com.zup.vacina.service;

import java.util.List;

import com.zup.vacina.domain.Cadastro;
import com.zup.vacina.repository.CadastroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CadastroService {
        
    @Autowired
    public CadastroRepository cadastroRepository;

    public Cadastro existe(Cadastro cadastro) throws Exception {

        if (existeCpf (cadastro.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"CPF ja existente");
        }
        else if (existeEmail (cadastro.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"E-mail ja existente");
        }
        else {
            return cadastroRepository.save(cadastro);
        }
    }


    public boolean existeCpf(String cpf) {

        List<Cadastro> buscaCpf = cadastroRepository.findByCpf(cpf);

        if (buscaCpf != null && !buscaCpf.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean existeEmail(String email) {
        List<Cadastro> buscaEmail = cadastroRepository.findByEmail(email);
        if (buscaEmail != null && !buscaEmail.isEmpty()) {
            return true;
        }
        return false;
    }

	public List<Cadastro> buscarCPF(String cpf) {
		return cadastroRepository.findByCpf(cpf);
	}

	public List<Cadastro> buscarNome(String nome) {
		return cadastroRepository.findByNome(nome);
	}

	public List<Cadastro> buscarEmail(String email) {
		return cadastroRepository.findByEmail(email);
	}
	public List<Cadastro> buscarTudo(){
		return cadastroRepository.findAll();
	}
}