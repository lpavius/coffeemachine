package org.formation.coffeemachine.presentation;

import java.util.List;
import java.util.Optional;

import org.formation.coffeemachine.model.Coffee;
import org.formation.coffeemachine.service.CoffeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffees") // factorisation du mapping
public class RestApiDemoController {

	private CoffeeServiceImpl coffeeServiceImpl;
//	private List<Coffee> coffees = new ArrayList<>();

	public RestApiDemoController(CoffeeServiceImpl coffeeServiceImpl) {
		this.coffeeServiceImpl = coffeeServiceImpl;
//		coffees.addAll(List.of(
//				new Coffee("Café Cereza"),
//				new Coffee("Café Ganador"),
//				new Coffee("Café Lareño"),
//				new Coffee("Café Três Pontas")
//				));
	}

	@GetMapping
	public List<Coffee> getCoffees() {
//		return coffeeRepository.findAll();
//		return coffees;
		return coffeeServiceImpl.getAllCoffees();
	}

	@PostMapping
	public Coffee postCoffee(@RequestBody Coffee coffee) {
//		coffee.setId(UUID.randomUUID().toString());
//		coffees.add(coffee);
//		return coffee;
//		return coffeeRepository.save(coffee);
		return coffeeServiceImpl.createCoffee(coffee);
	}

	@GetMapping("/{id}")
	public Optional<Coffee> getCoffeeById(@PathVariable String id) {
//		for (Coffee coffee : coffees) {
//			if (coffee.getId().equals(id)) {
//				return coffee;
//			}
//		}
//		return null;
//		return coffeeRepository.findById(id);
		return coffeeServiceImpl.getCoffee(id);
	}
	
	@GetMapping("/name/{name}")
	public Optional<Coffee> getCoffeeByName(@PathVariable String name) {
		return coffeeServiceImpl.coffeeName(name);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
//		int coffeeIndex = -1;
//		for (Coffee c : coffees) {
//			if (c.getId().equals(id)) {
//				coffeeIndex = coffees.indexOf(c); //recupere son index (position dans la liste)
//				coffees.set(coffeeIndex, coffee); //remplace dans la position donnée par un nouveau coffee
//			}
//		}
//		return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) 
//									: new ResponseEntity<>(coffee, HttpStatus.OK);
//		return (coffeeRepository.existsById(id)) 
//				? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
//				: new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
		return coffeeServiceImpl.UpdateCoffee(id, coffee);
	}

	@DeleteMapping("/{id}")
	public void deleteCoffee(@PathVariable String id) {
//		coffees.removeIf(c -> c.getId().equals(id)); // expression lambda
		coffeeServiceImpl.delete(id);
	}

}
