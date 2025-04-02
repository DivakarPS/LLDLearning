package models;

public class Card {
    private final long cardNumber;

    private final int pin;

    private final String name;

    private final String cardType;

    private final String bankName;

    public Card(long cardNumber, int pin, String name, String cardType, String bankName) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.name = name;
        this.cardType = cardType;
        this.bankName = bankName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public String getCardType() {
        return cardType;
    }

    public String getBankName() {
        return bankName;
    }
}
