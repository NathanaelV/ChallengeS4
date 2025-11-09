package br.com.challlenge.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class PacienteTO {
    private Long id;
    @NotBlank
    private String nome;
    @Past
    private LocalDate dataNascimento;
    @NotBlank
    private String documento;
    @Positive
    private Long codEndereco;
    @Positive
    private Long codContato;

    public PacienteTO() {}

    public PacienteTO(Long id, String nome, LocalDate dataNascimento, String documento, Long codEndereco, Long codContato) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.codEndereco = codEndereco;
        this.codContato = codContato;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Long getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Long codEndereco) {
        this.codEndereco = codEndereco;
    }

    public Long getCodContato() {
        return codContato;
    }

    public void setCodContato(Long codContato) {
        this.codContato = codContato;
    }
}

