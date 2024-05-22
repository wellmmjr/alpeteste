package org.example.data.dto.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id"})
public class ClienteDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String nome;

    private String email;

    private String telefone;

    private EnderecoDTO endereco;



    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ClienteDTO() {

    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO clienteDTO = (ClienteDTO) o;
        return endereco == clienteDTO.endereco && key.equals(clienteDTO.key) && nome.equals(clienteDTO.nome) && email.equals(clienteDTO.email) && telefone.equals(clienteDTO.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, nome, email, endereco, telefone);
    }

}
