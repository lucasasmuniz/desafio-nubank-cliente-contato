package spring.boot.desafio.nubank.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import spring.boot.desafio.nubank.dtos.ClienteDTO;
import spring.boot.desafio.nubank.services.ClienteService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	private final ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
