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

import com.zup.vacina.dto.AplicacaoResponse;



@Entity
@Table(name = "Aplicacao")
public class Aplicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)

    private Long id;
    @NotBlank(message = "Digite o nome da vacina")
    private String vacina;
    @NotBlank(message = "Digite o e-mail")
    @Email(message = "E-mail inválido")
    private String email;
    @NotNull(message = "Digite a data de aplicação")
    private LocalDate dataVacina;

    @Deprecated
    public Aplicacao() {

    }

    public Aplicacao(String vacina, String email, LocalDate dataVacina) {
        super();
        this.vacina = vacina;
        this.email = email;
        this.dataVacina = dataVacina;
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

	public AplicacaoResponse saidaVac() {
        return new AplicacaoResponse(this.id, this.vacina, this.email, this.dataVacina);
	}

}
