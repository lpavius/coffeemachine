package org.formation.coffeemachine.repository;

import java.util.Optional;

import org.formation.coffeemachine.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, String> {
	
	Optional<Coffee> findByName(String name);

}
