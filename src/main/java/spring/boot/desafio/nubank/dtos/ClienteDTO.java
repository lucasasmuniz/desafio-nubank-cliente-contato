package spring.boot.desafio.nubank.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.boot.desafio.nubank.entities.Cliente;
import spring.boot.desafio.nubank.entities.Contato;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
	
	private Long id;
	
	@Size(min = 3, message = "Tamanho mínimo de 3 caracteres")
	@NotBlank(message = "Campo Obrigatório")
	private String nome;
	private List<ContatoDTO> contatos = new ArrayList<>();
	
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
}
