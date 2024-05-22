package org.example.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.example.converter.mocks.MockPerson;
import org.example.data.model.Cliente;
import org.example.data.dto.v1.model.PersonVO;

public class DozerConverterTest {

	MockPerson inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getSecondName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Agender", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getSecondName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Agender", outputZero.getGender());
        
        PersonVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getSecondName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());
        
        PersonVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getSecondName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assert.assertEquals("Agender", outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Cliente output = DozerConverter.parseObject(inputObject.mockVO(), Cliente.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getSecondName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Agender", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Cliente> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Cliente.class);
        Cliente outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getSecondName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Agender", outputZero.getGender());
        
        Cliente outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getSecondName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());
        
        Cliente outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getSecondName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assert.assertEquals("Agender", outputTwelve.getGender());
    }
}
