package org.example.data.dto.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id"})
public class ProdutoDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String descricao;

    private Double preco;

    private FornecedorDTO fornecedor;

    public ProdutoDTO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public FornecedorDTO getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorDTO fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return key.equals(that.key) && descricao.equals(that.descricao) && preco.equals(that.preco) && fornecedor.equals(that.fornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, descricao, preco, fornecedor);
    }
}
