package br.com.challlenge.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class ContatoTO {
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;

    public ContatoTO() {}

    public ContatoTO(Long id, String email, String telefone) {
        this.id = id;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
