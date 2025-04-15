package state;

import enums.AtmState;
import models.Card;

public interface State {

    int initTransaction();

    boolean readCardDetailsAndPin(Card card, String pin);

    int dispenseCash(Card card, int transactionId, int amount);

    void ejectCard();

    boolean readCashWithdrawDetails(Card card,int transactionId, int amount) throws IllegalAccessException;

    boolean cancelTransaction(int transactionId);
    AtmState getState();

}
