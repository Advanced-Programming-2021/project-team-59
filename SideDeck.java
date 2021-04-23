
import java.util.ArrayList;

public class SideDeck {
    private ArrayList<Card> cardsInSideDeck;
    private String deckName;
    private Boolean isActive;

    public SideDeck(String deckName, Boolean isActive) {
        setDeckName(deckName);
        setActive(isActive);
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setCardsInSideDeck(ArrayList<Card> cardsInSideDeck) {
        this.cardsInSideDeck = cardsInSideDeck;
    }

    public String getDeckName() {
        return deckName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public ArrayList<Card> getCardsInSideDeck() {
        return cardsInSideDeck;
    }
}
