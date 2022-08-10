package com.endava.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.endava.spring.entities.Carte;

@Repository
public interface CarteRepository extends CrudRepository<Carte, Integer> {

}
