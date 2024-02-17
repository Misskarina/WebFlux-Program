package com.karina.fluxprogram;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository erepo;
	
	@RequestMapping("/test")
	
	public String test()
	{
		return"data tested";
	}
	
	@RequestMapping("save")
	public String save()
	{
	
	Employee e=new Employee();
	e.setName("Vicky");
	e.setCity("Tilaiya");
	
	erepo.save(e).subscribe();
	return"data saved";
	}
	
	@RequestMapping("/hello")
	public String data()
	{
		Employee e1=new Employee();
		e1.setName("Veer");
		e1.setCity("Jammu");
		
		Employee e2=new Employee();
		e2.setName("Vishal");
		e2.setCity("Kota");
		
		Employee e3=new Employee();
		e3.setName("Vishu");
		e3.setCity("Dumka");
		
		List<Employee>data=Arrays.asList(e1,e2,e3);
		erepo.saveAll(data).subscribe();
		return"data extended";
		
	}
	
	@RequestMapping(value="/new/{id}")
	Mono<Employee> byid(@PathVariable int id)
	{
		return erepo.findById(id);
	}
	
	@RequestMapping("/all")
	public Flux<Employee> all()
	{
		return erepo.findAll();
	}
	
	@RequestMapping(value="/find/{name}")
	Flux<Employee> byname(@PathVariable String name)
	{
		return erepo.findByName(name);
	}
	
	@RequestMapping(value="/city/{city}")
	Flux<Employee> bycity(@PathVariable String city)
	{
		return erepo.findByCity(city);
	}
	
	
	

}
