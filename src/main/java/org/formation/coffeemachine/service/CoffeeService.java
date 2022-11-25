package org.formation.coffeemachine.service;

import java.util.List;
import java.util.Optional;

import org.formation.coffeemachine.model.Coffee;
import org.springframework.http.ResponseEntity;

public interface CoffeeService {

	List<Coffee> getAllCoffees();

	Optional<Coffee> getCoffee(String id);
	
	Optional<Coffee> coffeeName(String name);

	ResponseEntity<Coffee> UpdateCoffee(String id, Coffee coffee);

	Coffee createCoffee(Coffee coffee);

	void delete(String id);

}