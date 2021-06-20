package Model;

import java.sql.Array;
import java.util.ArrayList;

public class Board {

    private Deck deck;
    private ArrayList<Card> deckZone;
    private Card fieldZone;
    private ArrayList<Card> allCards;
    private ArrayList<Card> monstersZone;
    private ArrayList<Card> spellsAndTrapsZone;
    private ArrayList<Card> graveYard;
    private ArrayList<Card> cardsInHand;

    public Board() {

        allCards = new ArrayList<>();
        monstersZone = new ArrayList<>();
        monstersZone.add(null);
        monstersZone.add(null);
        monstersZone.add(null);
        monstersZone.add(null);
        monstersZone.add(null);
        spellsAndTrapsZone = new ArrayList<>();
        spellsAndTrapsZone.add(null);
        spellsAndTrapsZone.add(null);
        spellsAndTrapsZone.add(null);
        spellsAndTrapsZone.add(null);
        spellsAndTrapsZone.add(null);
        graveYard = new ArrayList<>();
        cardsInHand = new ArrayList<>();
        deckZone = new ArrayList<>();
    }

    public void setZones() {
        deckZone.addAll(deck.getMainDeck().getCardsInMainDeck());
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setFieldZone(Card fieldZone) {
        this.fieldZone = fieldZone;
    }

    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    public ArrayList<Card> getDeckZone() {
        return deckZone;
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public ArrayList<Card> getGraveYard() {
        return graveYard;
    }

    public ArrayList<Card> getMonstersZone() {
        return monstersZone;
    }

    public ArrayList<Card> getSpellsAndTrapsZone() {
        return spellsAndTrapsZone;
    }

    public Card getFieldZone() {
        return fieldZone;
    }

    public Deck getDeck() {
        return deck;
    }

    public int numberOfMonstersOnBoard() {
        int number = 0;
        for (Card card : monstersZone) {
            if (card != null) {
                number++;
            }
        }
        return number;
    }

    public int numberOfSpellAndTrapsOnBoard() {
        int number = 0;
        for (Card card : spellsAndTrapsZone) {
            if (card != null) {
                number++;
            }
        }
        return number;
    }

    public void addCardFromDeckToHand(int number) {
        Card card = deckZone.get(number - 1);
        cardsInHand.add(card);
        deckZone.remove(number - 1);
    }
}
