package com.endava.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nume;

	@Column(nullable = false)
	private String prenume;

	@Column(nullable = false)
	private String nationalitate;

	public Autor() {

	}

	public Autor(String nume, String prenume, String nationalitate) {

		this.nume = nume;
		this.prenume = prenume;
		this.nationalitate = nationalitate;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) throws Exception {
		if (prenume == null) {
			throw new RuntimeException("Prenumele nu trebuie sa fie null");
		} else if (prenume.length() == 0) {
			throw new Exception("Prenumele nu trebuie sa fie un string gol");
		} else
			this.prenume = prenume;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) throws Exception {
		if (nume == null) {
			throw new Exception("Numele nu trebuie sa fie null");
		} else if (nume.length() == 0) {
			throw new RuntimeException("Numele nu trebuie sa fie un string gol");
		} else
			this.nume = nume;
	}

	public String getNationalitate() {
		return nationalitate;
	}

	public void setNationalitate(String nationalitate) {
		if (nationalitate == null) {
			throw new RuntimeException("Nationalitatea nu trebuie sa fie null");
		} else if (nationalitate.length() == 0) {
			throw new RuntimeException("Nationalitatea nu trebuie sa fie un string gol");
		} else
			this.nationalitate = nationalitate;
	}

	@Override
	public String toString() {
		return "Autor [nume=" + nume + ", prenume=" + prenume + ", nationalitate=" + nationalitate + "]";
	}

}
