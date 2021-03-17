package com.zup.vacina.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.vacina.domain.Cadastro;

import org.hibernate.validator.constraints.br.CPF;

public class CadastroRequest {
     
    @NotBlank(message = "Digite o nome")
    private String nome;
    @NotBlank(message = "Digite o e-mail")
    @Email(message = "E-mail inválido")
    private String email;
    @NotBlank(message = "Digite o CPF")
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotNull(message = "Digite a data")
    private LocalDate data;

    public Cadastro entrada(){
        return new Cadastro(this.nome, this.email, this.cpf, this.data);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}