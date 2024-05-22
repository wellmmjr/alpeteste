package org.example.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome_fantasia", unique = true)
    private String fantasia;

    @Column(name="cnpj")
    private String cnpj;

    @Column(name="fkendereco")
    private Long fkendereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getFkendereco() {
        return fkendereco;
    }

    public void setFkendereco(Long fkendereco) {
        this.fkendereco = fkendereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return id.equals(that.id) && fantasia.equals(that.fantasia) && cnpj.equals(that.cnpj) && fkendereco.equals(that.fkendereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fantasia, cnpj, fkendereco);
    }
}
