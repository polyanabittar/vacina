package com.zup.vacina.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AplicacaoResponse {
    private Long id;
    @NotBlank(message = "Nome da vacina em branco")
    private String vacina;
    @NotBlank(message = "Email em branco")
    private String email;
    @NotNull(message = "Data da aplicacao em branco")
    private LocalDate dataVacina;


    public AplicacaoResponse(Long id, String vacina, String email, LocalDate dataVacina) {
        super();
        this.id = id;
        this.vacina = vacina;
        this.email = email;
        this.dataVacina = dataVacina;
    }
 

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getEmail() {
		return email;
	}
    
	public void setEmail(String email) {
		this.email = email;
	}

    public LocalDate getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(LocalDate dataVacina) {
        this.dataVacina = dataVacina;
    }

}
