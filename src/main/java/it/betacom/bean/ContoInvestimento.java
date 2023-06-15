package it.betacom.bean;

import java.time.LocalDate;
import java.util.Random;

public class ContoInvestimento extends Conto {
    private Random random = new Random();

    public ContoInvestimento(Utente titolare, LocalDate dataApertura) {
        super(titolare, dataApertura);
    }

    @Override
    public void preleva(double quantita) {
        if(quantita > 0 && quantita <= saldo) {
            saldo -= quantita;
        }
    }

    @Override
    public double getTasso() {
        return 2 * random.nextDouble() - 1; // -1 a 1
    }

    @Override
    public void generaInteressi(LocalDate dataFine) {
        super.generaInteressi(dataFine);
    }
}
