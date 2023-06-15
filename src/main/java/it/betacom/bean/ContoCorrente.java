package it.betacom.bean;

import java.time.LocalDate;

public class ContoCorrente extends Conto {
	private static final double TASSO = 0.05;

	public ContoCorrente(Utente titolare, LocalDate dataApertura) {
		super(titolare, dataApertura);
	}

	@Override
	public void preleva(double quantita) {
		if (quantita > 0 && quantita <= saldo) {
			saldo -= quantita;
		}
	}

	@Override
	public void generaInteressi(LocalDate dataFine) {
	    super.generaInteressi(dataFine);
	}
	
	@Override
	public double getTasso() {
	    return TASSO;
	}
}