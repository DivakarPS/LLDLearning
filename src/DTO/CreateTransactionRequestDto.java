package DTO;

public class CreateTransactionRequestDto {
    private final String atmId;

    public CreateTransactionRequestDto(String atmId) {
        this.atmId = atmId;
    }
    public String getAtmId() {
        return atmId;
    }
}
