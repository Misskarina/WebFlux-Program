package com.karina.fluxprogram;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee,Integer> {

	Mono<Employee> findById(int id);

	Flux<Employee> findByName(String name);

	Flux<Employee> findByCity(String city);
}
