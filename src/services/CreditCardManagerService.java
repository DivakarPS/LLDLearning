package services;

import models.Card;

public class CreditCardManagerService implements CardManagerService{
    @Override
    public boolean validateCard(Card card, String pin) {
        return true;
    }

    @Override
    public boolean validateWithdrawal(Card card, double amount) {
        return true;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        return true;
    }
}
