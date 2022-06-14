package br.com.sap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.sap.exception.CpfException;
import br.com.sap.model.Cliente;
import br.com.sap.repository.ClienteRepository;
import br.com.sap.service.CpfService;

@RestController
public class ClienteControler {

		@Autowired
		private ClienteRepository clienteRepository;
		
		@Autowired
		private CpfService cpfService;
		 
		
		@GetMapping("todos")
		public List<Cliente> Listar(){
			return clienteRepository.findAll();
		}
		
		@PostMapping
		@RequestMapping("/post")
		public Cliente inserir (@RequestBody Cliente cliente) {
			return clienteRepository.save(cliente);
		}

		@GetMapping("api/{cpf}") 
		public ResponseEntity<String> validar(@PathVariable String cpf) throws CpfException {
			return ResponseEntity.ok().body(cpfService.validarId(cpf));
					
		}
}
