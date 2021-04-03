package com.neuwirt.mycar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neuwirt.mycar.model.Carro;
import com.neuwirt.mycar.repository.CarroRepository;

@RestController
@RequestMapping("/carros")
@CrossOrigin("*")
public class CarroController {

	@Autowired
	private CarroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Carro>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{placa}")
	public ResponseEntity<Carro> GetByPlaca(@PathVariable String placa){
		Carro carro = repository.findByPlaca(placa);
		if(!(carro == null)) {
			return ResponseEntity.ok(repository.findByPlaca(placa));			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<Carro>> GetByMarca(@PathVariable String marca){
		List<Carro> carro = repository.findAllByMarcaContainingIgnoreCase(marca);
		if(!carro.isEmpty()) {
		return ResponseEntity.ok(repository.findAllByMarcaContainingIgnoreCase(marca));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Carro> post (@RequestBody Carro carro){
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(carro));
	}
	
	@PutMapping
	public ResponseEntity<Carro> put (@RequestBody Carro carro){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(carro));
	}
	
	@DeleteMapping("/{placa}")
	public void delete(@PathVariable String placa) {
		repository.deleteById(placa);
	}
	
	
}
