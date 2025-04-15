package state;

import api.NodeBackendApi;
import enums.AtmState;
import factories.CardManagerFactory;
import models.Atm;
import models.Card;
import services.CardManagerService;

public class ReadingCashWithdrawalDetails implements State{

    private final Atm atm;

    public ReadingCashWithdrawalDetails(Atm atm) {
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
    public int dispenseCash(Card card,int transactionId, int amount) {
        throw new IllegalStateException("Cannot dispense cash without reading card details and pin");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card without cancelling the transaction");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) throws IllegalAccessException {
        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isWithdrawalValid = cardManagerService.validateWithdrawal(card,amount);

        if(isWithdrawalValid) {
            this.atm.changeState(new DispensingCashState(this.atm));
        } else {
            this.atm.changeState(new EjectingCardState(this.atm));
        }

        return isWithdrawalValid;
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        this.atm.changeState(new ReadyForTransactionState(atm,new NodeBackendApi()));
        return true;
    }

    @Override
    public AtmState getState() {
        return AtmState.READING_CASH_WITHDRAW_DETAILS;
    }
}
