package org.example.data.dto.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id"})
public class EnderecoDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    public EnderecoDTO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EnderecoDTO that = (EnderecoDTO) o;
        return key.equals(that.key) && rua.equals(that.rua) && Objects.equals(numero, that.numero) && bairro.equals(that.bairro) && cidade.equals(that.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, rua, numero, bairro, cidade);
    }
}
