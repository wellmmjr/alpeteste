package org.example.data.dto.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id"})
public class FornecedorDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String fantasia;

    private String cnpj;

    private EnderecoDTO endereco;

    public FornecedorDTO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        if (!super.equals(o)) return false;
        FornecedorDTO that = (FornecedorDTO) o;
        return key.equals(that.key) && fantasia.equals(that.fantasia) && cnpj.equals(that.cnpj) && endereco.equals(that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, fantasia, cnpj, endereco);
    }
}
