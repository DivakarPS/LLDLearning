package api;

import DTO.CreateTransactionRequestDto;
import DTO.GetAtmAmoutRequstDto;
import DTO.UpdateAtmStateRequestDto;

public interface BackendApi {
    int createTransaction(CreateTransactionRequestDto createTransactionDto);

    boolean updateState(UpdateAtmStateRequestDto updateAtmStateDto);

    int getAtmAmount(GetAtmAmoutRequstDto getAtmAmoutRequstDto);
}
