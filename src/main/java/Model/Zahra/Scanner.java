package Model.Zahra;

import Model.Board;
import Model.Card;
import Model.Monster;
import Model.Type;

public class Scanner extends Monster {
    private Card card;
    private Card firstCard;
    private boolean isFirstUse = true;

    public Scanner() {
        super("Scanner", Type.MACHINE);
    }

    public void specialAction (Board rivalBoard, Monster destroyedRivalMonster) {
        Card monster = (Scanner) card;
        firstCard = monster;
        if (isFirstUse) {
            monster = destroyedRivalMonster;
            isFirstUse = false;
        }else {
            monster = firstCard;
        }
    }
}