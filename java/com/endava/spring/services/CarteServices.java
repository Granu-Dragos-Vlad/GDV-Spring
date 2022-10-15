package com.endava.spring.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endava.spring.entities.Carte;
import com.endava.spring.repository.CarteRepository;

@Service
public class CarteServices {
	private final Logger LOGGER = LoggerFactory.getLogger(CarteServices.class);
	@Autowired
	private CarteRepository carterepository;

	public String saveCarte(Carte carte) {
		LOGGER.info("Creaza cartea " + carte);
		carterepository.save(carte);
		return "Carte salvata cu succes";
	}

	public List<Carte> findAllCarti() {
		LOGGER.info("Gaseste toate cartile ");
		List<Carte> carti = new ArrayList<Carte>();
		carterepository.findAll().forEach(carte -> carti.add(carte));
		return carti;
	}

	public Carte findCarte(int id) {
		LOGGER.info("Gaseste cartea cu id-ul " + id);
		Optional<Carte> carte = carterepository.findById(id);
		if (carte.isEmpty()) {
			throw new RuntimeException("Nu s-a gasit nici o carte cu id-ul " + id);

		} else
			return carte.get();

	}

	public void updateCarte(Carte carte, Integer id) {
		LOGGER.info("Update carte " + carte);
		carterepository.deleteById(id);
		carterepository.save(carte);
	}

	public void deleteCarte(int id) {
		LOGGER.info("Sterge cartea cu id-ul " + id);
		Optional<Carte> carte = carterepository.findById(id);
		if (carte.isPresent()) {
			carterepository.deleteById(id);
		} else
			throw new RuntimeException("Nu exista cartea cu id-ul " + id);
	}

}
