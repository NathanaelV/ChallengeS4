package br.com.challlenge.model.dto;

import java.time.LocalDate;

public class PacienteTO {
    private String nome;
    private LocalDate dataNascimento;
    private String documento;
    private EnderecoTO endereco;
    private ContatoTO contato;

    public PacienteTO() {}

    public PacienteTO(String nome, LocalDate dataNascimento, String documento, EnderecoTO endereco, ContatoTO contato) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.endereco = endereco;
        this.contato = contato;
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

    public EnderecoTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoTO endereco) {
        this.endereco = endereco;
    }

    public ContatoTO getContato() {
        return contato;
    }

    public void setContato(ContatoTO contato) {
        this.contato = contato;
    }
}

