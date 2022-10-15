package com.endava.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.endava.spring.entities.Autor;
import com.endava.spring.entities.Carte;
import com.endava.spring.entities.Cititor;
import com.endava.spring.services.CarteServices;

@RestController
public class CarteController {
	@Autowired
	private CarteServices carteservices;

	@PostMapping(path = "/savcarte")
	public String creazaCarte(@RequestBody Carte carte) {
		 return carteservices.saveCarte(carte);
	}

	@GetMapping(path = "/carti")
	public List<Carte> getCarti() {
		return carteservices.findAllCarti();
	}

	@GetMapping(path = "/carti/{id}")
	public Carte getCarte(@PathVariable Integer id) {
		return carteservices.findCarte(id);
	}

	@DeleteMapping(path = "/carti/{id}")
	public void stergeCarte(@PathVariable Integer id) {
		carteservices.deleteCarte(id);
	}

	@PutMapping(path = "/carti/{id}")
	public void updCarte(@PathVariable int id, @RequestBody Carte carte) {
		carteservices.updateCarte(carte, id);
	}

}
