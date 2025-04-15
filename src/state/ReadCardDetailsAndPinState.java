package state;

import api.NodeBackendApi;
import enums.AtmState;
import factories.CardManagerFactory;
import models.Atm;
import models.Card;
import services.CardManagerService;

public class ReadCardDetailsAndPinState implements State {

    private final Atm atm;

    public ReadCardDetailsAndPinState(Atm atm) {
        this.atm = atm;
    }


    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot initialize transaction while reading card details and Pin");
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        //what type of card manager is needed will be decided at the run time and if we decide the type during runtime
        //using if-else condition then it will violate open-close principle, so in that case we use factory design patterns

        //factory patter is a patter in which the class has only one responsibility of creating the classes using constructor
        //delaying the object initialization

        CardManagerService cardManagerService = CardManagerFactory.getCardManagerService(card.getCardType());
        boolean isCardValid = cardManagerService.validateCard(card,pin);

        if (isCardValid) {
            this.atm.changeState(new ReadingCashWithdrawalDetails(this.atm));
        } else {
            this.atm.changeState(new EjectingCardState(this.atm));
        }

        return isCardValid;
    }

    @Override
    public int dispenseCash(Card card,int transactionId, int amount) {
        throw new IllegalStateException("Cannot dispense cash while read card details and pin");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject card while reading card details and pin");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawal details while reading card details and pin");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        this.atm.changeState(new ReadyForTransactionState(this.atm, new NodeBackendApi()));
        return true;
    }

    @Override
    public AtmState getState() {
        return AtmState.READ_CARD_DETAILS_AND_PIN;
    }
}
