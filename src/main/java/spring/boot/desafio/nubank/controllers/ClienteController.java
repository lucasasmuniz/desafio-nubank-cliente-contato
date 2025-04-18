package spring.boot.desafio.nubank.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import spring.boot.desafio.nubank.dtos.ClienteDTO;
import spring.boot.desafio.nubank.dtos.ContatoDTO;
import spring.boot.desafio.nubank.services.ClienteService;
import spring.boot.desafio.nubank.services.ContatoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	private final ClienteService service;
	private final ContatoService contatoService;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@RequestBody @Valid ClienteDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping("/{id}/contatos")
	public ResponseEntity<List<ContatoDTO>> findClientContacts(@PathVariable Long id){
		return ResponseEntity.ok(contatoService.findClientContacts(id));
	}
}
