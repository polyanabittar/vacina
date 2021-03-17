package com.zup.vacina.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
 
public class CadastroResponse {
    @NotNull(message = "Id em branco!")
    private Long id;
    @NotBlank(message = "Nome em branco!")
    private String nome;
    @NotBlank(message = "Email em branco!")
    private String email;
    @NotNull(message = "Email em branco!")
    private LocalDate data;

    public CadastroResponse(Long id, String nome, String email, LocalDate data) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
