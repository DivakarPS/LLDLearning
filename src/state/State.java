package state;

import enums.AtmState;
import models.Card;

public interface State {

    int initTransaction();

    boolean readCardDetailsAndPin(Card card);

    int dispenseCash(int transactionId);

    void ejectCard();

    boolean readCashWithdrawDetails(int transactionId, int amount);

    AtmState getState();

}
