package com.endava.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cititor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nume;

	@Column(nullable = false)
	private Integer varsta;

	public Cititor() {
	}

	public Cititor(String nume, Integer varsta) {

		this.nume = nume;
		this.varsta = varsta;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		if (nume == null) {
			throw new RuntimeException("Numele nu trebuie sa fie null");
		} else if (nume.length() == 0) {
			throw new RuntimeException("Numele nu trebuie sa fie un string gol");
		} else
			this.nume = nume;
	}

	public Integer getVarsta() {
		return varsta;
	}

	public void setVarsta(Integer varsta) {
		if (varsta < 0) {
			throw new RuntimeException("Varsta nu poate fi un numar negativ");
		} else if (varsta == 0) {
			throw new RuntimeException("Varsta nu poate fi zero");
		} else
			this.varsta = varsta;
	}

	@Override
	public String toString() {
		return "Cititor [nume=" + nume + ", varsta=" + varsta + "]";
	}

}
