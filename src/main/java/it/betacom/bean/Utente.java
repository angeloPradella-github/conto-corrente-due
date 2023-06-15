package it.betacom.bean;

import java.time.LocalDate;

public class Utente {
    private String nome;
    private int id;
    private static int count = 0;  // Nuova variabile statica per generare un ID unico
    private LocalDate dataDiNascita;

    public Utente(String nome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.id = ++count;  // Genera un nuovo ID unico
        this.dataDiNascita = dataDiNascita;
    }

    // ----------GETTER AND SETTERS----------

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
}
