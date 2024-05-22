package org.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.example.converter.DozerConverter;
import org.example.data.model.Cliente;
import org.example.data.dto.v1.model.PersonVO;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	public PersonVO createPerson(PersonVO person) {
		
		var entity = DozerConverter.parseObject(person, Cliente.class);
		repository.save(entity);
		var entityVO = DozerConverter.parseObject(entity, PersonVO.class);
		
//		var entityVO = DozerConverter.parseObject(repository.save(entity), PersonVO.class); <-- maneira alternativa de realizar a conversão já salvando
		
		return entityVO;
	}
	
	public PersonVO updatePerson(PersonVO person) {
		var entity = repository.findById(person.getKey()). // atenção: este findById retorna um Person, visto que é da classe PersonRepository e ñ metodo desta propria
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;

		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setSecondName(person.getSecondName());
		entity.setGender(person.getGender());
		
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}

	@Transactional //notação para garantir qualidade ACID dos dados
	public void disablePerson(Long id) {
		repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;
		
		repository.disablePersons(id);
	}
	
	public void deletePerson(Long id) {
		Cliente entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;
		repository.delete(entity);
	}
	
	public PersonVO findById(Long id) {

		var entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	
	public Page<PersonVO> findAllByName(String firstName, Pageable pageable) {		
		var page = repository.findPersonByName(firstName, pageable);
		return page.map(this::convertToPersonVO);
	}
	
	public Page<PersonVO> findAll(Pageable pageable) {
/*		possibilita a lista com paginação e limite por pagina, ainda sendo convertida por DozerConverter e retorna List<PersonVO>
		var entities = repository.findAll(pageable).getContent();
		
		return DozerConverter.parseListObjects(entities, PersonVO.class);*/
		
		/*-----------------------------------------------------------------------------
		desta maneira possibilita o SPRING de gerar o HATEOAS automaticamente com indicativos de:
			prox pag,
			pag anterior
			primeira pag
			ultima pag
			assim como: qtd total de registro, qtd total de pag, etc
			SEGUE:*/
		
		var page = repository.findAll(pageable);
		return page.map(this::convertToPersonVO);
	}

	private PersonVO convertToPersonVO(Cliente entity) {
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
}
