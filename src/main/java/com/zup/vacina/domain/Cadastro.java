package com.zup.vacina.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.vacina.dto.CadastroResponse;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "Cadastro")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
    
    private Long id;
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


    @Deprecated
    public Cadastro() {

    }

    public Cadastro(String nome, String email, String cpf, LocalDate data) {
        super();
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.data = data;
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

    public LocalDate getdata() {
        return data;
    }

    public void setdata(LocalDate data) {
        this.data = data;
    }

    public CadastroResponse saida() {
        return new CadastroResponse(this.id, this.nome, this.email, this.data);

    }

 
}