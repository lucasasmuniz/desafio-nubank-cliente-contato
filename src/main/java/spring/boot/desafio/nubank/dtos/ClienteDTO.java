package spring.boot.desafio.nubank.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import spring.boot.desafio.nubank.entities.Cliente;
import spring.boot.desafio.nubank.entities.Contato;

public class ClienteDTO {
	
	private Long id;
	
	@Size(min = 3, message = "Tamanho mínimo de 3 caracteres")
	@NotBlank(message = "Campo Obrigatório")
	private String nome;
	private List<ContatoDTO> contatos = new ArrayList<>();
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public ClienteDTO(Cliente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}
	
	public ClienteDTO(Cliente entity, List<Contato> contatos) {
		this(entity);
		contatos.forEach(x -> {
			this.contatos.add(new ContatoDTO(x, entity));
		});
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

	public List<ContatoDTO> getContatos() {
		return contatos;
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
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(id, other.id);
	}
}
