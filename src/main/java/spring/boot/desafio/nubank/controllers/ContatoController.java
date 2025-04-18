package spring.boot.desafio.nubank.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import spring.boot.desafio.nubank.dtos.ContatoDTO;
import spring.boot.desafio.nubank.services.ContatoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contatos")
public class ContatoController {
	
	private final ContatoService service;
	
	@PostMapping
	public ResponseEntity<ContatoDTO> insert(@RequestBody ContatoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
