package Model.Effects.Equipe;

import Model.Card;
import Model.CardRectangle;
import Model.Monster;
import Model.Type;
import Client.Controller.Game;
import Client.View.GUI.GamePlay;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeOutUp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class SwordOfDarkDestruction extends EquipEffect {

    private CardRectangle selectedCardToEquip;

    public SwordOfDarkDestruction(Card card) {
        super(card);
    }

    @Override
    public void deActive() {
        monster.setDefencePower(monster.getDefencePower() + 200);
        monster.setAttackPower(monster.getAttackPower() - 400);
    }

    @Override
    public boolean activate(Game game) {
        GamePlay.showAlert(Alert.AlertType.INFORMATION, "Summon/Set Error", "select the Spellcaster or Fiend monster to equip");
        HBox box = new HBox(50);
        box.setAlignment(Pos.TOP_LEFT);
        box.setPadding(new Insets(10));
        ArrayList<CardRectangle> monsterZoneRectangles = new ArrayList<>();
        monsterZoneRectangles.add(game.currentMonster1);
        monsterZoneRectangles.add(game.currentMonster2);
        monsterZoneRectangles.add(game.currentMonster3);
        monsterZoneRectangles.add(game.currentMonster4);
        monsterZoneRectangles.add(game.currentMonster5);
        for (CardRectangle cardRectangle : monsterZoneRectangles) {
            if (cardRectangle.getRelatedCard() != null) {
                if (((Monster)cardRectangle.getRelatedCard()).getMonsterType() == Type.FIEND || ((Monster)cardRectangle.getRelatedCard()).getMonsterType() == Type.SPELL_CASTER) {
                    CardRectangle cardRectangle1 = new CardRectangle();
                    cardRectangle1.setRelatedCard(cardRectangle.getRelatedCard());
                    cardRectangle1.setFill(new ImagePattern(cardRectangle.getRelatedCard().getCardImage()));
                    cardRectangle1.setWidth(90);
                    cardRectangle1.setHeight(150);
                    cardRectangle1.setOnMouseClicked(event1 -> {
                        if (selectedCardToEquip != null) selectedCardToEquip.setStroke(Color.TRANSPARENT);
                        selectedCardToEquip = cardRectangle1;
                        selectedCardToEquip.setStroke(Color.GOLD);
                    });
                    box.getChildren().add(cardRectangle1);
                }
            }
        }
        Button tribute = new Button("Equip");
        Stage popupStage = new Stage(StageStyle.TRANSPARENT);
        popupStage.initOwner(Game.mainStage);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        Scene question = new Scene(box, Color.TRANSPARENT);
        question.getStylesheets().add("/Css/GamePlay.css");
        popupStage.setScene(question);
        tribute.setOnMouseClicked(event1 -> {
            if (selectedCardToEquip == null) {
                GamePlay.showAlert(Alert.AlertType.ERROR, "Equip Error", "no card is selected yet");
            } else {
                new FadeOutUp(box).play();
                popupStage.hide();
                Monster monster = (Monster) selectedCardToEquip.getRelatedCard();

                monster.setDefencePower(monster.getDefencePower() - 200);
                monster.setAttackPower(monster.getAttackPower() + 400);

                game.getCurrentUser().getBoard().getSpellMonsterEquip().put(card, monster);
                this.monster = monster;
                GamePlay.showAlert(Alert.AlertType.INFORMATION, "activate effect message", "spell activated");
            }
        });
        box.getChildren().add(tribute);
        popupStage.show();
        new FadeIn(box).play();
        return true;
    }

    @Override
    public boolean canBeActivated(Game game) {
        if (game.getChain().size() != 0) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (game.getCurrentUser().getBoard().getMonstersZone().get(i) != null) {
                if (((Monster) game.getCurrentUser().getBoard().getMonstersZone().get(i)).getMonsterType() == Type.FIEND) {
                    return true;
                }
                if (((Monster) game.getCurrentUser().getBoard().getMonstersZone().get(i)).getMonsterType() == Type.SPELL_CASTER) {
                    return true;
                }
            }
        }
        return false;
    }
}
