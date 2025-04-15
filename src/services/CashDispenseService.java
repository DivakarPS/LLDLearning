package services;

import models.Atm;

public interface CashDispenseService {

    void dispenseCash(Atm atm, double amount);

}
