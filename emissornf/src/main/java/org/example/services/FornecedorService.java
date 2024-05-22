package org.example.services;

import org.example.converter.DozerConverter;
import org.example.data.dto.v1.model.FornecedorDTO;
import org.example.data.model.Endereco;
import org.example.data.model.Fornecedor;
import org.example.exception.ExceptionResponse;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.EnderecoRepository;
import org.example.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EnderecoService enderecoService;

    public FornecedorDTO createFornecedor(FornecedorDTO fornecedor)
    {
        if(!enderecoService.enderecoNaoNulo(fornecedor.getEndereco()))
        {
            new ExceptionResponse(new Date(), "preencha endereco", "Campos para endereço não preenchidos corretamente");
        }

        var entidadeEndereco = DozerConverter.parseObject(fornecedor.getEndereco(), Endereco.class);
        enderecoRepository.save(entidadeEndereco);
        var entidadeFornecedor = DozerConverter.parseObject(fornecedor, Fornecedor.class);
        fornecedorRepository.save(entidadeFornecedor);

        return DozerConverter.parseObject(entidadeFornecedor, FornecedorDTO.class);
    }

    public FornecedorDTO findFornecedorById(Long id)
    {
        var entidade = fornecedorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;

        var fornecedorDTO = DozerConverter.parseObject(entidade, FornecedorDTO.class);

        fornecedorDTO.setEndereco(enderecoService.retornaEnderecoVinculado(fornecedorDTO.getEndereco().getKey()));

        return fornecedorDTO;
    }

    public List<FornecedorDTO> listAllCliente()
    {
        var fornecedoresDTO = DozerConverter.parseListObjects(fornecedorRepository.findAll(), FornecedorDTO.class);

        fornecedoresDTO.forEach(cli -> {
            cli.setEndereco(enderecoService.retornaEnderecoVinculado(cli.getEndereco().getKey()));
        });

        return fornecedoresDTO;
    }

    public Page<FornecedorDTO> listByPage(Pageable pageable)
    {
        var page = fornecedorRepository.findAll(pageable);
        return page.map(this::convertToFornecedorDTO);
    }

    private FornecedorDTO convertToFornecedorDTO(Fornecedor fornecedor)
    {
        return DozerConverter.parseObject(fornecedor, FornecedorDTO.class);
    }


}
