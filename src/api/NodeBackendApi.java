package api;

import DTO.CreateTransactionRequestDto;
import DTO.GetAtmAmoutRequstDto;
import DTO.UpdateAtmStateRequestDto;

public class NodeBackendApi implements BackendApi {
    @Override
    public int createTransaction(CreateTransactionRequestDto createTransactionDto) {

        if(createTransactionDto.getAtmId() == null || createTransactionDto.getAtmId().isEmpty()) {
            throw new IllegalArgumentException("atmId cannot be null or empty");
        }
        //connect to backend

        //return the response

        //return a random transaction id

        return (int) (Math.random() * 1000);
    }

    @Override
    public boolean updateState(UpdateAtmStateRequestDto updateAtmStateDto) {

        //assume that there an implementation that updates the state of the ATM

        return true; //mimced response
    }

    @Override
    public int getAtmAmount(GetAtmAmoutRequstDto getAtmAmoutRequstDto) {

        //backendCall for fetching the amount

        return 10000;
    }
    //should be only responsible for connecting to backend and returning response




}
