package com.endava.spring.entities;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Carte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nume;

	@Column(nullable = false)
	private String gen;

	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Autor_ID", referencedColumnName = "ID")
	private Autor autor;

	@OneToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CITITOR_ID", referencedColumnName = "ID")
	private Cititor cititor;

	public Carte() {

	}

	public Carte(String nume, String gen, Autor autor, Cititor cititor) {

		this.nume = nume;
		this.gen = gen;
		this.autor = autor;
		this.cititor = cititor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cititor getCititor() {
		return cititor;
	}

	public void setCititor(Cititor cititor) {
		this.cititor = cititor;
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

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) throws Exception {
		if (gen == null) {
			throw new Exception("Genul nu trebuie sa fie null");
		} else if (gen.length() == 0) {
			throw new Exception("Genul nu trebuie sa fie un string gol");
		} else
			this.gen = gen;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Carte [nume=" + nume + ", gen=" + gen + ", autor=" + autor + ", cititor=" + cititor + "]";
	}

}
