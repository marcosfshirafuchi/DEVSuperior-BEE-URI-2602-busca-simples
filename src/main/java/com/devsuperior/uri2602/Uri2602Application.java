package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h1> DEVSUPERIOR - Java Spring Professional - Capítulo:  JPA, consultas SQL e JPQL</h1>
 * AULA: URI 2602 - Elaborando a consulta
 * <p>
 * <b>Note:</b> Desenvolvido na linguagem Java.
 *
 * @author  Marcos Ferreira Shirafuchi
 * @version 1.0
 * @since   16/07/2024
 */


@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CustomerMinProjection> list = repository.search1("rs");
		List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
		System.out.println("\n*** RESULTADO SQL RAIZ:");
		for (CustomerMinDTO obj : result1){
			System.out.println(obj);
		}
		System.out.println("\n\n");
		List<CustomerMinDTO> result2= repository.search2("rs");
		System.out.println("\n*** RESULTADO JPQL:");
		for (CustomerMinDTO obj : result2){
			System.out.println(obj);
		}
		System.out.println("\n\n");
	}
}
