package org.example.services;

import org.example.converter.DozerConverter;
import org.example.data.dto.v1.model.ClienteDTO;
import org.example.data.dto.v1.model.EnderecoDTO;
import org.example.data.model.Cliente;
import org.example.data.model.Endereco;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.ClienteRepository;
import org.example.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EnderecoService enderecoService;

    public ClienteDTO createCliente(ClienteDTO cliente)
    {
        var endereco = DozerConverter.parseObject(cliente.getEndereco(), Endereco.class);
        enderecoRepository.save(endereco);

        var entidade = DozerConverter.parseObject(cliente, Cliente.class);
        clienteRepository.save(entidade);

        var entidadeCliDTO = DozerConverter.parseObject(entidade, ClienteDTO.class);

        return entidadeCliDTO;
    }

    public ClienteDTO findClienteById(Long id)
    {
        var entidade = clienteRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;

        var clienteDTO = DozerConverter.parseObject(entidade, ClienteDTO.class);

        clienteDTO.setEndereco(enderecoService.retornaEnderecoVinculado(clienteDTO.getEndereco().getKey()));

        return clienteDTO;
    }

    public List<ClienteDTO> listAllCliente()
    {
        var clientesDTO = DozerConverter.parseListObjects(clienteRepository.findAll(), ClienteDTO.class);

        clientesDTO.forEach(cli -> {
            cli.setEndereco(enderecoService.retornaEnderecoVinculado(cli.getEndereco().getKey()));
        });

        return clientesDTO;
    }


}
