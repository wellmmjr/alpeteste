package org.example.data.dto.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.example.data.model.tipomodelo.FormaPagamentoEnum;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonPropertyOrder({"id"})
public class VendaDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    private String descricao;

    private FormaPagamentoEnum pagamento;

    private List<ProdutoDTO> produtos;

    private Date dataVenda;

    private Double totalVenda;
}
