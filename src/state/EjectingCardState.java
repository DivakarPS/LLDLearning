package state;

import api.BackendApi;
import api.NodeBackendApi;
import enums.AtmState;
import models.Atm;
import models.Card;

public class EjectingCardState implements State {

    private final Atm atm;

    public EjectingCardState(Atm atm) {
        this.atm = atm;
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
        throw new IllegalStateException("Cannot dispense cash");
    }

    @Override
    public void ejectCard() {
        System.out.println("Ejecting Card, Please take the Card");
        this.atm.changeState(new ReadyForTransactionState(this.atm, new NodeBackendApi()));
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
        return AtmState.EJECTING_CARD;
    }
}
