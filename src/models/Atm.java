package models;

import DTO.UpdateAtmStateRequestDto;
import api.BackendApi;
import api.NodeBackendApi;
import state.ReadyForTransactionState;
import state.State;

public class Atm {
    private final String atmId;
    private State state;
    private final BackendApi backendApi;

    public Atm(String atmId) {
        this.atmId = atmId;
        this.backendApi = new NodeBackendApi();
        this.state = new ReadyForTransactionState(this, this.backendApi);
    }

    public String getAtmId() {
        return atmId;
    }

    public void changeState(State newState) {
        this.state = newState;

        //now call the server to persist the state change
        this.backendApi.updateState(new UpdateAtmStateRequestDto(this.getAtmId(), newState.getState()));
    }
}
