package com.zup.vacina.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zup.vacina.domain.Aplicacao;

public class AplicacaoRequest {

    @NotBlank(message = "Digite o nome da vacina")
    private String vacina;
    @NotBlank(message = "Digite o e-mail")
    @Email(message = "E-mail inválido")
    private String email;
    @NotNull(message = "Digite a data da aplicação")
    private LocalDate dataVacina;


    public Aplicacao entradaVac(){
        return new Aplicacao(this.vacina, this. email, this.dataVacina);
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

    public void setDataVacina (LocalDate dataVacina) {
        this.dataVacina = dataVacina;
    }


}