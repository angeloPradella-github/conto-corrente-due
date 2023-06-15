package it.betacom.business;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import it.betacom.bean.ContoCorrente;
import it.betacom.bean.Utente;
import java.util.Scanner;

public class Gestore {
	private Utente utente;
	private ContoCorrente contoCorrente;

	public void avvia() {
		Scanner scanner = new Scanner(System.in);
		// ------------------ACQUISIZIONE DATI---------------------
		System.out.print("==========Registrazione Utente ==========\n");

		// ...
		// il tuo codice esistente per la registrazione dell'utente
		// ...

		// ------------------SISITEMA DI PRELIEVO E VERSAMENTO---------------------
		prelevaVersa(scanner);
	}

	private void prelevaVersa(Scanner scanner) {
		boolean continua = true;
		do {
			System.out.println("\nScegli un'opzione:");
			System.out.println("1: Prelievo");
			System.out.println("2: Versamento");
			System.out.println("3: Esci");

			String input = scanner.nextLine();

			switch (input) {
			case "1": // Prelievo
				System.out.print("Inserisci l'importo da prelevare: ");
				try {
					double quantita = Double.parseDouble(scanner.nextLine());
					contoCorrente.preleva(quantita);
					System.out.println("Prelievo effettuato con successo. Il tuo saldo attuale è: "
							+ contoCorrente.getSaldo());
				} catch (NumberFormatException e) {
					System.out.println("Importo non valido. Devi inserire un numero.");
				}
				break;

			case "2": // Versamento
				System.out.print("Inserisci l'importo da versare: ");
				try {
					double quantita = Double.parseDouble(scanner.nextLine());
					contoCorrente.versa(quantita);
					System.out.println("Versamento effettuato con successo. Il tuo saldo attuale è: "
							+ contoCorrente.getSaldo() + " Euro");
				} catch (NumberFormatException e) {
					System.out.println("Importo non valido. Devi inserire un numero.");
				}
				break;

			case "3": // Esci
				System.out.println("Arrivederci!");
				continua = false;
				break;

			default:
				System.out.println("Opzione non valida. Inserisci 1, 2 o 3.");
				break;
			}
		} while (continua);
	}

	public static int calcEta(LocalDate dataDiNascita) {
		LocalDate now = LocalDate.now(); // La data attuale
		Period p = Period.between(dataDiNascita, now);
		return p.getYears();
	}

	private static int verificaMaggiorenne(LocalDate dataDiNascita, Scanner scanner) {
		if (calcEta(dataDiNascita) < 18) {
			String scelta;
			do {
				System.out.println(
						"<<Attenzione: Per accedere al servizio bisogna avere più di 18 anni.>>\n\tSe hai sbagliato, premi 1 per reinserire, altrimenti premi 2 per uscire: ");
				scelta = scanner.nextLine();
				if (!scelta.equals("1") && !scelta.equals("2")) {
					System.out.println("Scelta non valida. Devi inserire 1 per reinserire la data o 2 per uscire.");
				}
			} while (!scelta.equals("1") && !scelta.equals("2"));

			return scelta.equals("2") ? 2 : 1;
		}

		return 0; // 0 -> l'utente è già maggiorenne
	}
}