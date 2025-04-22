package spring.boot.desafio.nubank.dtos;
import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.boot.desafio.nubank.entities.Cliente;
import spring.boot.desafio.nubank.entities.Contato;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {
	private Long id;
	
	@Size(min = 3, message = "Tamanho mínimo de 3 caracteres")
	@NotBlank(message = "Campo Obrigatório")
	private String nome;
	
	@Email(message = "Campo deve ser um email válido")
	@NotBlank(message = "Campo Obrigatório")
	private String email;
	
	@NotNull(message = "Campo Obrigatório")
	@Positive(message = "Campo deve ser positivo")
	private Long clienteId;
	
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
}
