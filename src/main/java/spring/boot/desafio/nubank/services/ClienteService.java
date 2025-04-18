package spring.boot.desafio.nubank.services;

import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.boot.desafio.nubank.dtos.ClienteDTO;
import spring.boot.desafio.nubank.repositories.ClienteRepository;

@RequiredArgsConstructor
@Service
public class ClienteService {
	
	private final ClienteRepository repository;
	
	public List<ClienteDTO> findAll(){
		return repository.findAll().stream().map(x -> new ClienteDTO(x, x.getContatos())).toList();
	}
}
