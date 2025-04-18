package spring.boot.desafio.nubank.dtos;

import java.util.Objects;

import spring.boot.desafio.nubank.entities.Cliente;
import spring.boot.desafio.nubank.entities.Contato;

public class ContatoDTO {
	private Long id;
	private String nome;
	private String email;
	private Long clienteId;
	
	public ContatoDTO() {
	}
	
	public ContatoDTO(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public ContatoDTO(Contato entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
	}
	
	public ContatoDTO(Contato entity, Cliente cliente) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.clienteId = cliente.getId();
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

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContatoDTO other = (ContatoDTO) obj;
		return Objects.equals(id, other.id);
	}
}
