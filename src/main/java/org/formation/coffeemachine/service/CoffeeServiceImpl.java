package org.formation.coffeemachine.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.formation.coffeemachine.model.Coffee;
import org.formation.coffeemachine.repository.CoffeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CoffeeServiceImpl implements CoffeeService {

	private CoffeeRepository coffeeRepository;

	public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
		super();
		this.coffeeRepository = coffeeRepository;
	}
	
	@PostConstruct
	private void loadData() {
		coffeeRepository.saveAll(List.of(
				new Coffee("Café Cereza"),
				new Coffee("Café Ganador"),
				new Coffee("Café Lareño"),
				new Coffee("Café Três Pontas")
		));
	}
	
	@Override
	public List<Coffee> getAllCoffees() {
		return coffeeRepository.findAll();
	}
	
	@Override
	public Optional<Coffee> getCoffee(String id) {
		return coffeeRepository.findById(id);
	}
	
	
	@Override
	public ResponseEntity<Coffee> UpdateCoffee(String id, Coffee coffee) {
		return (coffeeRepository.existsById(id)) 
				? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
				: new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
	}
	
	@Override
	public Coffee createCoffee(Coffee coffee) {
		coffee.setId(UUID.randomUUID().toString());
		return coffeeRepository.save(coffee);
		
	}
	
	@Override
	public void delete(String id) {
		coffeeRepository.deleteById(id);
	}

	@Override
	public Optional<Coffee> coffeeName(String name) {
		return coffeeRepository.findByName(name);
	}

}
