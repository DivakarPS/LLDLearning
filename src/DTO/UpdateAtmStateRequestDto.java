package DTO;

import enums.AtmState;

public class UpdateAtmStateRequestDto {

    private final String atmId;
    private final AtmState State;

    public UpdateAtmStateRequestDto(String atmId, AtmState State) {
        this.atmId = atmId;
        this.State = State;
    }

    public String getAtmId() {
        return atmId;
    }
    public AtmState getState() {
        return State;
    }

}