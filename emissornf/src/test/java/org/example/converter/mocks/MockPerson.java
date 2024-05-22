package org.example.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import org.example.data.model.Cliente;
import org.example.data.dto.v1.model.PersonVO;

public class MockPerson {

	public Cliente mockEntity() {
    	return mockEntity(0);
    }
    
    public PersonVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Cliente> mockEntityList() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        for (int i = 0; i < 14; i++) {
            clientes.add(mockEntity(i));
        }
        return clientes;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    private Cliente mockEntity(Integer number) {
    	Cliente cliente = new Cliente();
    	cliente.setAddress("Addres Test" + number);
        cliente.setFirstName("First Name Test" + number);
        cliente.setGender(((number % 2)==0) ? "Agender" : "Female");
        cliente.setId(number.longValue());
        cliente.setSecondName("Last Name Test" + number);
        return cliente;
    }

    private PersonVO mockVO(Integer number) {
    	PersonVO person = new PersonVO();
    	person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Agender" : "Female");
        person.setKey(number.longValue());
        person.setSecondName("Last Name Test" + number);
        return person;
    }
}
