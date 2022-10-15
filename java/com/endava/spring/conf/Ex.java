package com.endava.spring.conf;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.endava.spring.entities.Autor;
import com.endava.spring.entities.Carte;
import com.endava.spring.entities.Cititor;
import com.endava.spring.services.CarteServices;

@Component
public class Ex {
	private final Logger LOGGER = LoggerFactory.getLogger(Ex.class);
	@Autowired
	private CarteServices carteservices;

	@Bean
	@Profile("default")
	private void defaultData() {
		LOGGER.info("Initializare date pe profilul dev");
		carteservices.saveCarte(
				new Carte("Moara cu noroc", "nuvela", new Autor("Slavici", "Ioan", "RO"), new Cititor("Andrei", 25)));
		carteservices.saveCarte(
				new Carte("Baltagul", "roman", new Autor("Sadoveanu", "Mihail", "RO"), new Cititor("Mihai", 16)));
		carteservices.saveCarte(
				new Carte("Povestea lui Harap-Alb", "basm cult", new Autor("Creanga", "Ion", "RO"), new Cititor("Horatiu", 20)));
	}

}
