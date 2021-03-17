package com.zup.vacina.controller;

import com.zup.vacina.domain.Aplicacao;
import com.zup.vacina.dto.AplicacaoRequest;
import com.zup.vacina.dto.AplicacaoResponse;
import com.zup.vacina.service.AplicacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/aplicacaoVacina")
public class AplicacaoController {
    
    @Autowired
    AplicacaoService aplicacaoService;

    @PostMapping
    public ResponseEntity<AplicacaoResponse> aplicada(@Validated @RequestBody AplicacaoRequest aplicacaoRequest) throws Exception {
        
        Aplicacao aplicacao = aplicacaoRequest.entradaVac();
        aplicacaoService.existeVac(aplicacao);
        AplicacaoResponse aplicacaoResponse = aplicacao.saidaVac();
        return ResponseEntity.status(HttpStatus.CREATED).body(aplicacaoResponse);
    }

}