package it.betacom.bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Conto {
    protected Utente titolare;
    protected LocalDate dataApertura;
    protected LocalDate dataUltimaGenerazioneInteressi;
    protected double saldo;

    public Conto(Utente titolare, LocalDate dataApertura) {
        this.titolare = titolare;
        this.dataApertura = dataApertura;
        this.dataUltimaGenerazioneInteressi = dataApertura; // Inizialmente uguale alla data di apertura
        this.saldo = 1000;
    }

    public void versa(double quantita) {
        if(quantita > 0) {
            this.saldo += quantita;
        }
    }

    public abstract void preleva(double quantita);
    
    public abstract double getTasso();


    //public abstract void generaInteressi();
    
    public void generaInteressi(LocalDate dataFine) {
        if (dataFine.isAfter(dataUltimaGenerazioneInteressi) && dataFine.isBefore(LocalDate.now())) {
            long giorni = ChronoUnit.DAYS.between(dataUltimaGenerazioneInteressi, dataFine);
            saldo += saldo * getTasso() / 365 * giorni;
            dataUltimaGenerazioneInteressi = dataFine;
        }
    }

	public Utente getTitolare() {
		return titolare;
	}

	public void setTitolare(Utente titolare) {
		this.titolare = titolare;
	}

	public LocalDate getDataApertura() {
		return dataApertura;
	}

	public void setDataApertura(LocalDate dataApertura) {
		this.dataApertura = dataApertura;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Getters and setters
	
}