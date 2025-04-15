package factories;

import enums.CardType;
import models.Card;
import services.CardManagerService;
import services.CreditCardManagerService;
import services.DebitCardManagerService;

public class CardManagerFactory {

    public static CardManagerService getCardManagerService(CardType cardType) {
        CardManagerService cardManagerService = null;
        if(cardType.equals(CardType.DEBIT)){
            cardManagerService = new DebitCardManagerService();
        } else if(cardType.equals(CardType.CREDIT)){
            cardManagerService = new CreditCardManagerService();
        } else{
            throw new IllegalArgumentException("Card type not supported");
        }
        return cardManagerService;
    }

}
