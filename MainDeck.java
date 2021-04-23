import java.util.ArrayList;

public class MainDeck {
    private ArrayList<Card> cardsInMainDeck;
    private String deckName;
    private Boolean isActive;

    public MainDeck(String deckName, Boolean isActive) {
        new ArrayList<>();
        setDeckName(deckName);
        setActive(isActive);
    }

    //todo COMPLETE HERE !

    private String printMonsters() {
        ArrayList<Card> monsters = new ArrayList<>();

        for (Card card : cardsInMainDeck) {
            if (card instanceof Monster) {
                monsters.add(card);
                System.out.println(card.getName() + ": " + card.getDescription());
            }
        }

        return "";
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setCardsInMainDeck(ArrayList<Card> cardsInMainDeck) {
        this.cardsInMainDeck = cardsInMainDeck;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public ArrayList<Card> getCardsInMainDeck() {
        return cardsInMainDeck;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getDeckName() {
        return deckName;
    }


    @Override
    public String toString() {
        return "Deck: " + this.getDeckName() +
                "\nMain deck" +
                "\nMonsters:" +
                printMonsters() +
                ", deckName='" + deckName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
