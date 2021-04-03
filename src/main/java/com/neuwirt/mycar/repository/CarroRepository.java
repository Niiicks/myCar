package com.neuwirt.mycar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neuwirt.mycar.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, String> {
	public Carro findByPlaca(String placa);
	public List<Carro> findAllByMarcaContainingIgnoreCase(String marca);
}
