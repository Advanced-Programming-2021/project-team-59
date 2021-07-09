package View.Menu;

import Controller.Regex;
import Model.User;
import View.GUI.MainMenuGraphic;
import View.GUI.ScoreBoardGraphic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.regex.Matcher;

public class ScoreBoard extends Menu {
    public static Stage mainStage;

    public ScoreBoard() {
        super("ScoreBoard Menu", null);
    }

    public ScoreBoard(Menu parentMenu) {
        super("ScoreBoard Menu", parentMenu);
    }

    @Override
    public void execute() {
        String input = scanner.nextLine();
        input = editSpaces(input);
        if (Regex.getMatcher(input, Regex.showCurrentMenu).find()) {
            this.showName();
            this.execute();
        } else if (Regex.getMatcher(input, Regex.menuExit).find()) {
            this.menuExit();
        } else if (Regex.getMatcher(input, Regex.menuEnter).find()) {
            Matcher matcher = Regex.getMatcher(input, Regex.menuEnter);
            if (matcher.find()) {
                this.menuEnter(matcher.group(1));
                this.execute();
            }
        } else if (Regex.getMatcher(input, Regex.userLogout).find()) {
            this.logoutUser();
        } else if (Regex.getMatcher(input, Regex.showScoreBoard).find()) {
            User.sortAllUsers();
            showScoreBoard();
            this.execute();
        } else {
            System.out.println("invalid command!");
            this.execute();
        }
    }

    private void showScoreBoard() {
        int rank = 1;
        System.out.println(rank + "- " + User.getAllUsers().get(0));
        for (int i = 1; i < User.getAllUsers().size(); i++) {
            if (User.getAllUsers().get(i).getScore() < User.getAllUsers().get(i - 1).getScore()) {
                System.out.println(++rank + "- " + User.getAllUsers().get(i));
            } else {
                System.out.println(rank + "- " + User.getAllUsers().get(i));
            }
        }
    }

    private String editSpaces(String string) {
        return string.replaceAll("(\\s)+", " ");
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception {
        MainMenuGraphic mainMenuGraphic = new MainMenuGraphic();
        mainMenuGraphic.start(mainStage);
    }

    public static User getLoggedUser() {
        return loggedUser;
    }
}
