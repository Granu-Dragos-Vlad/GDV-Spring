package com.springboot.proiect;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.endava.spring.entities.Autor;
import com.endava.spring.entities.Carte;
import com.endava.spring.entities.Cititor;

class EntitiesTests {
	private Carte carte;
	private Autor autor;
	private Cititor cititor;

	@Test
	public void carteNumeShouldNotBeNullOrBlank() {
		carte = new Carte();
		assertThatThrownBy(() -> carte.setNume(null)).hasMessage("Numele nu trebuie sa fie null");
		assertThatThrownBy(() -> carte.setNume("")).hasMessage("Numele nu trebuie sa fie un string gol");
	}

	@Test
	public void carteGenShouldNotBeNullOrBlank() {
		carte = new Carte();
		assertThatThrownBy(() -> carte.setGen(null)).hasMessage("Genul nu trebuie sa fie null");
		assertThatThrownBy(() -> carte.setGen("")).hasMessage("Genul nu trebuie sa fie un string gol");
	}

	@Test
	public void autorNumeShouldNotBeNullOrBlank() {
		autor = new Autor();
		assertThatThrownBy(() -> autor.setNume(null)).hasMessage("Numele nu trebuie sa fie null");
		assertThatThrownBy(() -> autor.setNume("")).hasMessage("Numele nu trebuie sa fie un string gol");
	}

	@Test
	public void autorPrenumeShouldNotBeNullOrBlank() {
		autor = new Autor();
		assertThatThrownBy(() -> autor.setPrenume(null)).hasMessage("Prenumele nu trebuie sa fie null");
		assertThatThrownBy(() -> autor.setPrenume("")).hasMessage("Prenumele nu trebuie sa fie un string gol");
	}

	@Test
	public void autorNationalitateShouldNotBeNullOrBlank() {
		autor = new Autor();
		assertThatThrownBy(() -> autor.setNationalitate(null)).hasMessage("Nationalitatea nu trebuie sa fie null");
		assertThatThrownBy(() -> autor.setNationalitate(""))
				.hasMessage("Nationalitatea nu trebuie sa fie un string gol");
	}

	@Test
	public void cititorNumeShouldNotBeNullOrBlank() {
		cititor = new Cititor();
		assertThatThrownBy(() -> cititor.setNume(null)).hasMessage("Numele nu trebuie sa fie null");
		assertThatThrownBy(() -> cititor.setNume("")).hasMessage("Numele nu trebuie sa fie un string gol");

	}

	@Test
	public void cititorVarstaShouldNotBeNegativeOrZero() {
		cititor = new Cititor();
		assertThatThrownBy(() -> cititor.setVarsta(-8)).hasMessage("Varsta nu poate fi un numar negativ");
		assertThatThrownBy(() -> cititor.setVarsta(0)).hasMessage("Varsta nu poate fi zero");
	}

}
