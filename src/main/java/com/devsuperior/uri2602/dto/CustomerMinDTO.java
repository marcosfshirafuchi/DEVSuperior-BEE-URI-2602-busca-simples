package com.devsuperior.uri2602.dto;

import com.devsuperior.uri2602.projections.CustomerMinProjection;
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
public class CustomerMinDTO {
    private String name;
    public CustomerMinDTO(){

    }

    public CustomerMinDTO(String name) {
        this.name = name;
    }
    public CustomerMinDTO(CustomerMinProjection projection) {
        name = projection.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerMinDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
