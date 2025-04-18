package spring.boot.desafio.nubank.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.boot.desafio.nubank.dtos.ClienteDTO;
import spring.boot.desafio.nubank.entities.Cliente;
import spring.boot.desafio.nubank.repositories.ClienteRepository;

@RequiredArgsConstructor
@Service
public class ClienteService {
	
	private final ClienteRepository repository;
	
	public List<ClienteDTO> findAll(){
		return repository.searchClienteEContatos().stream().map(x -> new ClienteDTO(x, x.getContatos())).toList();
	}

	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setNome(dto.getNome());
		entity = repository.save(entity);
		
		return new ClienteDTO(entity);
	}
}
