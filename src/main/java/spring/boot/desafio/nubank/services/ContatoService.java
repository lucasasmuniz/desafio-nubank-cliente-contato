package spring.boot.desafio.nubank.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.boot.desafio.nubank.dtos.ContatoDTO;
import spring.boot.desafio.nubank.entities.Contato;
import spring.boot.desafio.nubank.repositories.ClienteRepository;
import spring.boot.desafio.nubank.repositories.ContatoRepository;

@RequiredArgsConstructor
@Service
public class ContatoService {

	private final ContatoRepository repository;
	private final ClienteRepository clienteRepository;
	
	public ContatoDTO insert(ContatoDTO dto) {
		Contato entity = new Contato();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setCliente(clienteRepository.getReferenceById(dto.getClienteId()));
		
		entity = repository.save(entity);
		
		return new ContatoDTO(entity, entity.getCliente());
	}
}
