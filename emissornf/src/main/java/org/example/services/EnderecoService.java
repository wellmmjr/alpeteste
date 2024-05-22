package org.example.services;

import org.example.converter.DozerConverter;
import org.example.data.dto.v1.model.EnderecoDTO;
import org.example.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;
    protected Boolean enderecoNaoNulo(EnderecoDTO endereco)
    {
        return (endereco.getBairro().isEmpty() || endereco.getRua().isEmpty() || endereco.getCidade().isEmpty()) ? false : true;
    }

    protected EnderecoDTO retornaEnderecoVinculado(Long id)
    {
        var endereco = enderecoRepository.findById(id);

        return DozerConverter.parseObject(endereco, EnderecoDTO.class);
    }
}
