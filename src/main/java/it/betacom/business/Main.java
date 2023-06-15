package it.betacom.business;

import java.time.LocalDate;
import java.time.Month;
import it.betacom.bean.*;

public class Main {
    public static void main(String[] args) {
        // Creazione conti
        Utente utente = new Utente("Mario Rossi", LocalDate.of(1990, Month.JANUARY, 1));
        Conto contoCorrente = new ContoCorrente(utente, LocalDate.of(2021, 1, 1));
        Conto contoDeposito = new ContoDeposito(utente, LocalDate.of(2021, 1, 1));

        // Simulazione operazioni
        System.out.println("Inizio simulazione conto corrente:");

        System.out.println("Saldo iniziale: " + String.format("%.2f", contoCorrente.getSaldo()));
        contoCorrente.generaInteressi(LocalDate.of(2021, 6, 30));
        System.out.println("Saldo al 30/06/2021: " + String.format("%.2f", contoCorrente.getSaldo()));
        contoCorrente.preleva(900);
        System.out.println("Saldo dopo prelievo di 900 euro: " + String.format("%.2f", contoCorrente.getSaldo()));
        contoCorrente.generaInteressi(LocalDate.of(2021, 7, 31));
        System.out.println("Saldo al 31/07/2021: " + String.format("%.2f", contoCorrente.getSaldo()));
        contoCorrente.versa(400);
        System.out.println("Saldo dopo versamento di 400 euro: " + String.format("%.2f", contoCorrente.getSaldo()));
        contoCorrente.generaInteressi(LocalDate.of(2021, 12, 31));
        System.out.println("Saldo al 31/12/2021: " + String.format("%.2f", contoCorrente.getSaldo()));
        
        System.out.println("\nInizio simulazione conto deposito:");
        contoDeposito.versa(1000);
        System.out.println("Saldo dopo versamento di 1000 euro: " + String.format("%.2f", contoDeposito.getSaldo()));
        contoDeposito.preleva(500);
        System.out.println("Saldo dopo prelievo di 500 euro: " + String.format("%.2f", contoDeposito.getSaldo()));
        contoDeposito.generaInteressi(LocalDate.of(2021, 12, 31));
        System.out.println("Saldo al 31/12/2021: " + String.format("%.2f", contoDeposito.getSaldo()));
        contoDeposito.generaInteressi(LocalDate.of(2022, 12, 31));
        System.out.println("Saldo al 31/12/2022: " + String.format("%.2f", contoDeposito.getSaldo()));
        contoDeposito.generaInteressi(LocalDate.now());
        System.out.println("Saldo alla data di oggi: " + String.format("%.2f", contoDeposito.getSaldo()));
    }
}
