package com.zup.vacina.controller;

import com.zup.vacina.domain.Cadastro;
import com.zup.vacina.dto.CadastroRequest;
import com.zup.vacina.dto.CadastroResponse;
import com.zup.vacina.service.CadastroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cadastroUsuario")
public class CadastroController {
    
    @Autowired
    CadastroService cadastroService;

    @PostMapping
    public ResponseEntity<CadastroResponse> cadastrar(@Validated @RequestBody CadastroRequest cadastroRequest) throws Exception {
        Cadastro cadastro = cadastroRequest.entrada();
        cadastroService.existe(cadastro);
        CadastroResponse cadastroResponse = cadastro.saida();
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastroResponse);
    }

} 
