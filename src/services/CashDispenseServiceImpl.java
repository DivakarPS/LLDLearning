package services;

import DTO.GetAtmAmoutRequstDto;
import api.BackendApi;
import models.Atm;

public class CashDispenseServiceImpl implements CashDispenseService {

    private final BackendApi backendApi;

    public CashDispenseServiceImpl(BackendApi backendApi) {
        this.backendApi = backendApi;
    }

    @Override
    public void dispenseCash(Atm atm, double amount) {

        int atmAmount = this.backendApi.getAtmAmount(new GetAtmAmoutRequstDto(atm.getAtmId()));
        if(atmAmount < amount) {
            throw new RuntimeException("Amount not enough");
        }

        System.out.print("Dispensing Cash : " + amount);

    }
}
