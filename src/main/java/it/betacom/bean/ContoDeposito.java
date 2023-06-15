package it.betacom.bean;

import java.time.LocalDate;

public class ContoDeposito extends Conto {
    private static final double TASSO = 0.10;
    private static final double LIMITE_PRELIEVO = 1000;

    public ContoDeposito(Utente titolare, LocalDate dataApertura) {
        super(titolare, dataApertura);
    }

    @Override
    public void preleva(double quantita) {
        if (quantita > 0 && quantita <= saldo && quantita <= LIMITE_PRELIEVO) {
            saldo -= quantita;
        }
    }

    @Override
    public double getTasso() {
        return TASSO;
    }

    @Override
    public void generaInteressi(LocalDate dataFine) {
        super.generaInteressi(dataFine);
    }
}
