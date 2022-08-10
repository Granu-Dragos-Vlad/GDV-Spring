package com.endava.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.endava.spring.entities.Autor;
import com.endava.spring.entities.Carte;
import com.endava.spring.entities.Cititor;
import com.endava.spring.services.CarteServices;

@RestController
public class CarteController {
	@Autowired
	private CarteServices carteservices;

	@PostMapping(path = "/carti/{nume}/{gen}/{numeautor}/{prenumeautor}/{nationalitate}/{numecititor}/{varsta}")
	public void creazaCarte(@PathVariable String nume, @PathVariable String gen, @PathVariable String numeautor,
			@PathVariable String prenumeautor, @PathVariable String nationalitate, @PathVariable String numecititor,
			@PathVariable Integer varsta) {
		Autor autor = new Autor(numeautor, prenumeautor, nationalitate);
		Cititor cititor = new Cititor(numecititor, varsta);
		carteservices.saveCarte(new Carte(nume, gen, autor, cititor));
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

	@PutMapping(path = "/carti/{id}/{nume}/{gen}/{numeautor}/{prenumeautor}/{nationalitate}/{numecititor}/{varsta}")
	public void updCarte(@PathVariable Integer id, @PathVariable String nume, @PathVariable String gen,
			@PathVariable String numeautor, @PathVariable String prenumeautor, @PathVariable String nationalitate,
			@PathVariable String numecititor, @PathVariable Integer varsta) {
		Carte carte = new Carte(nume, gen, new Autor(numeautor, prenumeautor, nationalitate),
				new Cititor(numecititor, varsta));
		carteservices.updateCarte(carte, id);
	}

}
