package state;

import api.NodeBackendApi;
import enums.AtmState;
import factories.CardManagerFactory;
import models.Atm;
import models.Card;
import services.CardManagerService;
import services.CashDispenseService;
import services.CashDispenseServiceImpl;

public class DispensingCashState implements State {
    private final Atm atm;
    private final CashDispenseService cashDispenseService;

    public DispensingCashState(Atm atm) {
        this.atm = atm;
        this.cashDispenseService = new CashDispenseServiceImpl(new NodeBackendApi());
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize transaction");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot read card details and pin");
    }

    @Override
    public int dispenseCash(Card card, int transactionId, int amount) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isTxnSuccessfull = cardManagerService.doTransaction(card, amount, transactionId);

        if (isTxnSuccessfull) {
            this.cashDispenseService.dispenseCash(this.atm, amount);
            this.atm.changeState(new EjectingCardState(this.atm));
        } else {
            System.out.println("Dispensing cash failed");
            this.atm.changeState(new EjectingCardState(this.atm));
        }
        return amount;
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) throws IllegalAccessException {
        throw new IllegalStateException("Cannot read cash withdraw details");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction");
    }

    @Override
    public AtmState getState() {
        return AtmState.DISPENSING_CASH;
    }
}
