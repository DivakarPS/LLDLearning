package state;

import DTO.CreateTransactionRequestDto;
import api.BackendApi;
import enums.AtmState;
import models.Card;
import models.Atm;

public class ReadyForTransactionState implements State{

    public final Atm atm;
    public final BackendApi backendApi;

    public ReadyForTransactionState(Atm atm, BackendApi backendApi) {
        this.atm = atm;
        this.backendApi = backendApi;
    }

    @Override
    public int initTransaction() {
        //could have done better, not creating object here
        CreateTransactionRequestDto createTransactionDto = new CreateTransactionRequestDto(this.atm.getAtmId());
        int transactionId = this.backendApi.createTransaction(createTransactionDto);

        if(transactionId == 0){
            throw new RuntimeException("Transaction creation failed");
        }

        this.atm.changeState(new ReadCardDetailsAndPinState(this.atm));
        return transactionId;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot dispense Cash without inserting card details");
    }

    @Override
    public int dispenseCash(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot dispense Cash without card details and Pin");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot eject Card without card details and Pin");
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, int transactionId, int amount) {
        throw new IllegalStateException("Cannot read cash withdrawDetails without card details and Pin");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction without card details and Pin");
    }

    @Override
    public AtmState getState() {
        return AtmState.READY_FOR_TRANSACTION;
    }
}
