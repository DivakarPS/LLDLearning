package DTO;

public class GetAtmAmoutRequstDto {
    private final String atmId;


    public GetAtmAmoutRequstDto(String atmId) {
        this.atmId = atmId;
    }

    public String getAtmId() {
        return atmId;
    }
}
