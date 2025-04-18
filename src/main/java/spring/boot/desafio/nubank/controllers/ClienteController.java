package spring.boot.desafio.nubank.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
