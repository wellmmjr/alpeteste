package org.example.data.model;

import org.example.data.model.tipomodelo.FormaPagamentoEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="dtvenda", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    @Column(name="pagamento", nullable = false)
    private FormaPagamentoEnum pagamentoEnum;

    @Column(name="fkcliente", nullable = false)
    private int fkCliente;

    @Column(name="totalvenda")
    private Double total;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public FormaPagamentoEnum getPagamentoEnum() {
        return pagamentoEnum;
    }

    public void setPagamentoEnum(FormaPagamentoEnum pagamentoEnum) {
        this.pagamentoEnum = pagamentoEnum;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return fkCliente == venda.fkCliente && id.equals(venda.id) && dataVenda.equals(venda.dataVenda) && pagamentoEnum == venda.pagamentoEnum && total.equals(venda.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataVenda, pagamentoEnum, fkCliente, total);
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
