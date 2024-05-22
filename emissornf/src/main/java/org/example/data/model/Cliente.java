package org.example.data.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome", nullable = false, length = 20)
	private String nome;
	
	@Column(name="email", length = 50)
	private String email;

	@Column(name="telefone", length = 20)
	private String telefone;

	@Column(name="fkendereco", length = 100)
	private int endereco;
	
	@Column(length = 20)
	private Boolean enabled;
	
	
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Cliente() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cliente cliente = (Cliente) o;
		return endereco == cliente.endereco && id.equals(cliente.id) && nome.equals(cliente.nome) && email.equals(cliente.email) && telefone.equals(cliente.telefone) && enabled.equals(cliente.enabled);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, email, telefone, endereco, enabled);
	}
}
