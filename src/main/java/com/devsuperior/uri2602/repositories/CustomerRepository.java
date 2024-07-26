package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

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


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(nativeQuery = true,value = "SELECT name FROM customers WHERE UPPER(state) = UPPER(:state)")
    List<CustomerMinProjection> search1(String state);

    //JPQL
    @Query("SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name)  FROM Customer obj WHERE UPPER(obj.state) = UPPER(:state)")
    List<CustomerMinDTO> search2(String state);
}
